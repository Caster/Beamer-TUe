Beamer-TUe
==========
An extension of the TU/e theme for the LaTeX Beamer class.

Table of contents
-----------------
  * [Usage instructions](#usage-instructions)
  * [Options for the theme](#theme-options)
  * [Quoting](#quoting)
  * [TU/e font installation](#tue-font-installation)
    * [Font installation on Windows (MiKTeX)](#font-installation-on-windows-miktex)

Usage instructions
------------------
After cloning the repository or downloading a tarball from GitHub, you need to 
grab the contents of the `theme` directory and put that in the same directory as 
where your main TeX source file is located. After that, you should be able to 
use the TU/e Beamer theme in your Beamer presentation using the following lines:

```
\usetheme[department=winuk,official=false,theme=cyan,innovation=false]{tue2008}
\mode<presentation>
```

There are many more options and of course, you can play with the values. The 
above values are by no means recommended or default, just an example. Also refer 
to [Options for the theme](#theme-options). It is probably best to put these 
lines right after your `\usepackage` declarations, which in turn should come 
after the

```
\documentclass[12pt, aspectratio=169]{beamer} % aspectratio = 43 or 169
```

line at the top of your TeX source file.

At the moment, the theme only works correctly when using PDFLaTeX. With XeLaTeX, 
there are strange problems: for example the slide number becomes black instead 
of the correct theme colour.

Theme options
-------------
The theme supports the following options, which can be passed to it in the usual 
way: in the `\usetheme` line (refer to [Usage 
instructions](#usage-instructions)). All options are key/value pairs. Most 
options were present in the original TU/e theme, but they are documented here 
too for completeness.

| Option key               | Default value  | Possible values                                                                                                | Option description                                                                                                                                                             |
| ------------------------ | -------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| theme                    | red            | red, cyan, blue, green, orange                                                                                 | Used to change the colour theme of all slides.                                                                                                                                 |
| department               | none           | none, ele, eleuk, win, winuk, bmt, bmtuk, bwk, bwkuk, id, iduk, chem, chemu, tm, tmuk, phys, physu, wtb, wtbuk | Used to change the deparment at the bottom of all slides. For example, 'winuk' will render 'department of mathematics and computer science' on every slide.                    |
| statustext               | (empty string) | Any string.                                                                                                    | Text to put right after the department. Can be used to specify a custom value for the department, in conjuction with using 'none' for the department option.                   |
| titlelogo                | (empty string) | Any string.                                                                                                    | Optional path to an image file, for inclusion on the title slide.                                                                                                              |
| titlebgimage             | (empty string) | Any string.                                                                                                    | Optional path to an image file, for inclusion on the title slide. This image will be put in the background, spanning the entire visible height of the slide and right aligned. |
| titlebgimagetransparency | 0.65           | Number between 0 and 1.                                                                                        | The opacity of the block in theme colour that forms the background of the title on the title slide, but sits in front of the background image (if specified). 0 means that the background is fully transparent; 1 means that it is fully opaque.             |
| compress                 | false          | n.a.                                                                                                           | Pass this option without a value to enable the Beamer compress flag.                                                                                                           |
| official                 | false          | true, false                                                                                                    | Will trigger some styling differences when used. It is recommended to not use this option normally.                                                                            |
| innovation               | true           | true, false                                                                                                    | If the slogan 'where innovation starts' should be printed on the title slide.                                                                                                  |
| realpagenumbers          | false          | true, false                                                                                                    | If apart from the slide number, the page number should be put on every slide.                                                                                                  |
| tocslides                | false          | true, false                                                                                                    | If at the start of every `\section`, a slide should be inserted with a table of contents in which the section is highlighted.                                                  |
| slidesperpage            | 1              | Any positive integer.                                                                                          | The number of slides to put per page. When handout is used, this value is set to 2 and cannot be overridden.                                                                   |

Quoting
-------
The Beamer TU/e theme comes with a custom quote environment. That is, the 
default quote environment is styled in a more TU/e-like way. If you do not like 
the new environment, you can use the `\begin{oldquote}` and `\end{oldquote}` 
commands to get the old quote environment without additional styling.

The complete documentation of the new quote environment is as follows.

    \begin{quote}[quote width][top margin]{name of cited person}[extra information about cited person]
        ...
    \end{quote}

All arguments are optional, despite the fact that the name of the cited person 
should be given using `{...}` instead of the usual `[...]`. This is done so that 
the spacing parameters need not be specified to be able to specify the cited 
person and information about them. Default values are as follows:

| Option key           | Default value
| -------------------- | ---------------
| quote width          | `0.9\textwidth`
| top margin           | `.4em`
| name of cited person | (empty string)
| extra information    | (empty string)

As is shown in the `quote-environment` example in this repository, you can 
change the size of the quotation marks that are set around the quote. This can 
be done by redefining the `\quotesize` command. The default value is 60, but you 
can change it to 40 by putting `\renewcommand{\quotesize}{40}` anywhere before 
your quote.

TU/e font installation
----------------------
You may notice that the font is incorrect (and there may be warnings coming from 
LaTeX telling you so). In that case, you probably need to install the TU/e font 
in such a way that LaTeX can use it. On Linux and Mac, you can do so as follows 
below. On Windows, refer to [the Windows 
subsection](#font-installation-on-windows-miktex). If you encounter a problem, 
do not hesitate to open an [issue](https://github.com/Caster/Beamer-TUe/issues). 
In case there is a problem with Beamer-TUe, you are welcome to open a [pull 
request](https://github.com/Caster/Beamer-TUe/pulls).

  1. Download the `latex_huisstijl.zip` ZIP archive from the `TUe-fonts` folder 
in the repository. You can skip this step if you cloned the repository.
  2. Unzip the archive in a `texmf` directory in your home folder, so `~/texmf`. 
If this `texmf` folder does not exist yet, you can create it. The name and 
location of this folder are important, because your LaTeX distribution will look 
in this directory for fonts and packages.
  3. Next, open a command line and `cd` to `~/texmf/dvips/config/`. Run the 
following commands (if you do not have `sudo` installed, run them as root, so 
`su` before you start them and without `sudo`):

<pre>
<b>$</b> sudo updmap-sys --enable Map=tue.map
<b>$</b> sudo mktexlsr
</pre>

Congratulations, you should now be able to use the `zmb` font family in LaTeX 
and use the TU/e font! Do not forget to `\usepackage[T1]{fontenc}` however.

###Font installation on Windows (MiKTeX)
Installing the TU/e font on Windows in such a way that LaTeX can use it is 
slightly more elaborate than on Linux and Mac, but it should be easy to follow 
the steps in this section to make it work. The steps are taken from [this answer 
at TeX.SE](http://tex.stackexchange.com/a/95456/23145), but has been changed so 
that it specifically targets the TU/e font installation, instead of Frutiger.

####Create a local texmf tree
If no local texmf tree exists, you can create the folder `C:/localtexmf`. The 
subtrees you need depend on what you want to install into this directory, but in 
your case it should be sufficient to include the following:

    C:/localtexmf/doc/latex
                 /tex/latex

Then go to MikTeX's *Settings (Admin)* in the Start Menu, click on the *Roots* 
tab and add `C:/localtexmf`. Next click on the *General* tab and click on 
*Refresh FNDB*.

Complete instructions for the creation of a local texmf tree in MiKTeX can be 
found [here](http://tex.stackexchange.com/a/69484/14497). More information on 
TDS compliance can be found [here](http://tug.org/tds/tds.html).

####Install fonts
Download 
[`latex_huisstijl.zip`](https://github.com/Caster/Beamer-TUe/raw/master/TUe-fonts/latex_huisstijl.zip)
from this repository and unpack it in your `C:/localtexmf` folder (or copy its 
contents there). This means that for example the file

    dvips/config/tue.map

would go in `C:/localtexmf/dvips/config`, the folder

    fonts/tfm/tue/huisstyl

would go in `C:/localtexmf/fonts/tfm/tue/huisstyl`, et cetera.

Next, on the Windows command prompt, type

    initexmf --admin --edit-config-file updmap

then add the line

    Map tue.map

and save. Afterwards, run

     initexmf -u
     initexmf --mkmaps

Finally, refresh the FNDB. Try running `kpsewhich tue.map` on the Windows 
command prompt. It should return the location of the map file; if it doesn't, 
somehow it is not visible to TeX. Otherwise, you are done and are now able to 
use the `zmb` font family in LaTeX and use the TU/e font! Do not forget to 
`\usepackage[T1]{fontenc}` however. All examples in this repository use the 
`zmb` font family and hence should look better after you have done all this.
