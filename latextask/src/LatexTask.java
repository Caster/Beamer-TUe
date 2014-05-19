import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * Simple Ant task that can compile LaTeX documents.
 * 
 * @author Thom Castermans
 */
public class LatexTask extends Task {

    /**
     * Directory to change to before running latex.
     */
    private String dir = "";
    /**
     * Input file.
     */
    private String input;
    /**
     * Output type. Can be "dvi" (will trigger running `latex`) or "pdf" (will
     * trigger running `pdflatex`).
     */
    private String output = "pdf";
    /**
     * If the latex call should be verbose or not.
     */
    private Boolean verbose = false;
    
    @Override
    public void execute() throws BuildException {
        File cwd = new File(getProject().getBaseDir(), dir);
        
        // check input and output
        checkInput(cwd);
        checkOutput();
        
        // run latex command
        String latexCmd = (output.equals("pdf") ? "pdflatex" : "latex");
        String[] cmd = new String[] { latexCmd, "-shell-escape",
                "-interaction=nonstopmode", input };
        try {
            log("Running " + latexCmd + " on \"" + input + "\"...");
            Process p = Runtime.getRuntime().exec(cmd, null, cwd);
            // force the process to run by reading its output...
            String line;
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((line = inputReader.readLine()) != null) {
                if (verbose) {
                    System.out.println(line);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new BuildException("Could not run \"" + cmd + "\".");
        }
    }
    
    /**
     * Set the directory to change to before running latex.
     * 
     * @param dir Directory to change to before running latex.
     */
    public void setDir(String dir) {
        this.dir = dir;
    }
    
    /**
     * Set the file to run pdflatex on.
     * 
     * @param input File to run pdflatex on.
     */
    public void setInput(String input) {
        this.input = input;
    }
    
    /**
     * Set the type of output file that the task should generate.
     * 
     * @param output Type of output file. Can be "pdf" or "dvi". 
     */
    public void setOutput(String output) {
        this.output = output;
    }
    
    /**
     * Set if output of the latex command should be shown or not.
     * 
     * @param verbose If output of latex should be shown or not.
     */
    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Check if the input file given by the global {@code input} variable exists
     * and is readable. If not, throws a {@link BuildException} with an
     * appropriate message. Otherwise, this method will do nothing.
     * 
     * @param cwd Directory to check in.
     * @throws BuildException If the input file given by {@code input} does not
     *                        exist or is not readable.
     */
    private void checkInput(File cwd) throws BuildException {
        if (input == null) {
            throw new BuildException("Parameter \"input\" must be set.");
        }
        
        File inputFile = new File(cwd, input);
        if (!inputFile.exists()) {
            throw new BuildException("Input file \"" + input + "\" does not "
                    + "exist.");
        } else if (!inputFile.canRead()) {
            throw new BuildException("Input file \"" + input + "\" is not "
                    + "readable. Please change the file permissions.");
        }
    }
    
    /**
     * Check the output argument.
     * 
     * @throws BuildException If the output argument has an invalid value.
     */
    private void checkOutput() throws BuildException {
        if (output.equals("pdf") || output.equals("dvi")) {
            return;
        }
        throw new BuildException("Output file type must be either \"pdf\" or "
                + "\"dvi\".");
    }
}
