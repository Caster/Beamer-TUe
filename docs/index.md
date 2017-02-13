Beamer-TUe
==========
An extension of the TU/e theme for the LaTeX Beamer class.

Table of contents
-----------------
  * [Usage instructions](#usage-instructions)
  * [Creating slides](#creating-slides)
  * [Options for the theme](#theme-options)
  * [Theme colours](#theme-colours)
  * [Quoting](#quoting)
  * [TU/e font installation](#tue-font-installation)
    * [Font installation on Windows (MiKTeX)](#font-installation-on-windows-miktex)

Usage instructions
------------------
After cloning the repository or downloading a tarball from GitHub, you need to
grab the contents of the `theme` directory and put that in the same directory as
where your main TeX source file is located. After that, you should be able to
use the TU/e Beamer theme in your Beamer presentation using the following lines:

```latex
\usetheme[department=winuk,official=false,theme=cyan,innovation=false]{tue2008}
\mode<presentation>
```

There are many more options and of course, you can play with the values. The
above values are by no means recommended or default, just an example. Also refer
to [Options for the theme](#theme-options). It is probably best to put these
lines right after your `\usepackage` declarations, which in turn should come
after the

```latex
\documentclass[12pt, aspectratio=169]{beamer} % aspectratio = 43 or 169
```

line at the top of your TeX source file.

At the moment, the theme only works correctly when using PDFLaTeX. With XeLaTeX,
there are strange problems: for example the slide number becomes black instead
of the correct theme colour.

Creating slides
---------------
Slides can be created just normally, like explained in the Beamer manual; see,
for example, [here](https://www.ctan.org/pkg/beamer). There are a few special
commands you can use to achieve special effects in the TU/e theme.

### The title frame

The standard way to make title frames in Beamer is

````latex
\begin{frame}
    \titlepage
\end{frame}
````

This also works somewhat in the TU/e style, but the resulting title slide does
not look like the usual TU/e-styled title slides at all. Therefore, this theme
provides a special environment `titleframe`:

````latex
\begin{titleframe}
\end{titleframe}
````

### Plain frames

The syntax

````latex
\begin{frame}[plain]
    % ...
\end{frame}
````

to make plain frames (without titles and backgrounds) is not supported in this
theme. Use the special environment `plainframe` instead:

````latex
\begin{plainframe}
    % ...
\end{plainframe}
````

Theme options
-------------
The theme supports the following options, which can be passed to it in the usual
way: in the `\usetheme` line (refer to [Usage
instructions](#usage-instructions)). All options are key/value pairs. Most
options were present in the original TU/e theme, but they are documented here
too for completeness.

| Option key               | Default value  | Possible values                                                                                                | Option description                                                                                                                                                                                                                               |
| ------------------------ | -------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| theme                    | red            | Refer to the [theme colours](#theme-colours) section.                                                          | Used to change the colour theme of all slides.                                                                                                                                                                                                   |
| department               | none           | none, ele, eleuk, win, winuk, bmt, bmtuk, bwk, bwkuk, id, iduk, chem, chemu, tm, tmuk, phys, physu, wtb, wtbuk | Used to change the deparment at the bottom of all slides. For example, 'winuk' will render 'department of mathematics and computer science' on every slide.                                                                                      |
| statustext               | (empty string) | Any string.                                                                                                    | Text to put right after the department. Can be used to specify a custom value for the department, in conjuction with using 'none' for the department option.                                                                                     |
| titlelogo                | (empty string) | Any string.                                                                                                    | Optional path to an image file, for inclusion on the title slide.                                                                                                                                                                                |
| titlebgimage             | (empty string) | Any string.                                                                                                    | Optional path to an image file, for inclusion on the title slide. This image will be put in the background, spanning the entire visible height of the slide and right aligned.                                                                   |
| titlebgimagetransparency | 0.65           | Number between 0 and 1.                                                                                        | The opacity of the block in theme colour that forms the background of the title on the title slide, but sits in front of the background image (if specified). 0 means that the background is fully transparent; 1 means that it is fully opaque. |
| compress                 | false          | n.a.                                                                                                           | Pass this option without a value to enable the Beamer compress flag.                                                                                                                                                                             |
| official                 | false          | true, false                                                                                                    | Will trigger some styling differences when used. It is recommended to not use this option normally.                                                                                                                                              |
| innovation               | false          | true, false                                                                                                    | If the slogan 'where innovation starts' should be printed on the title slide.                                                                                                                                                                    |
| realpagenumbers          | false          | true, false                                                                                                    | If apart from the slide number, the page number should be put on every slide.                                                                                                                                                                    |
| tocslides                | false          | true, false                                                                                                    | If at the start of every `\section`, a slide should be inserted with a table of contents in which the section is highlighted.                                                                                                                    |
| slidesperpage            | 1              | Any positive integer.                                                                                          | The number of slides to put per page. When handout is used, this value is set to 2 and cannot be overridden.                                                                                                                                     |
| tocplain                 | true           | true, false                                                                                                    | If table of content slides are included whether to use the plain layout or the TUE layout (includes the toc-slide in the numbering).                                                                                                             |
| tocstyle                 | clear          | clear, all                                                                                                     | The 'all' option shows all subsections and sections on the table of contents slide, where as the 'clear' option only shows the subsections of the current section.                                                                               |
| tuefont                  | true           | true, false                                                                                                    | If option is set to true, it will use the tuefont otherwise it will use the default font.                                                                                                                                                        |

Theme colours
-------------
The following theme colours are available for use. Some colours can be used
through multiple different names, just because we want to facilitate easy-to-use
colour names and simulataneously precise colour names too (the PMS ones).

| Preview                                                                                                          | Keys                       | HTML      |
| ---------------------------------------------------------------------------------------------------------------- | -------------------------- |-----------|
| ![PMS Warm Red](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-warm-red.png)         | `red`, `pms-warm-red`      | `#f73131` |
| ![PMS Process Cyan](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-process-cyan.png) | `cyan`, `pms-process-cyan` | `#00a2de` |
| ![PMS 300](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-300.png)                   | `blue`, `pms-300`          | `#0066cc` |
| ![PMS 375](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-375.png)                   | `green`, `pms-375`         | `#84d200` |
| ![PMS 137](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-137.png)                   | `orange`, `pms-137`        | `#ff9a00` |
| ![PMS 206](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-206.png)                   | `darkred`, `pms-206`       | `#d6004a` |
| ![PMS 226](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-226.png)                   | `darkpink`, `pms-226`      | `#d6007b` |
| ![PMS 253](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-253.png)                   | `purple`, `pms-253`        | `#ad20ad` |
| ![PMS 2748](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-2748.png)                 | `darkblue`, `pms-2748`     | `#101073` |
| ![PMS Yellow 012](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-yellow-012.png)     | `yellow`, `pms-yellow-012` | `#ffdd00` |
| ![PMS 396](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-396.png)                   | `lime`, `pms-396`          | `#cedf00` |
| ![PMS Green](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-green.png)               | `aqua`, `pms-green`        | `#00ac82` |
| ![PMS 3135](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-3135.png)                 | `marine`, `pms-3135`       | `#0092b5` |
| ![PMS White](https://raw.githubusercontent.com/Caster/Beamer-TUe/master/docs/images/pms-white.png)               | `white`, `pms-white`       | `#ffffff` |

Note that for the PMS Yellow 012 and PMS White theme colours, the text colour
for headers will be black. In all other cases, the text colour will be white.

Finally, it is possible to select a custom theme colour. The text is always
white at the moment, so be aware of that. Also, it is not recommended to use a
custom colour, because the TU/e has a well-defined and well-balanced colour
palette. Now that you are warned: you can pass the value `\#BADA55`, or any
other HTML colour code, to use that as a theme colour. Again, the text will be
white and we do not recommend you do this, but you can if you really want to.

Quoting
-------
The Beamer TU/e theme comes with a custom quote environment. That is, the
default quote environment is styled in a more TU/e-like way. If you do not like
the new environment, you can use the `\begin{oldquote}` and `\end{oldquote}`
commands to get the old quote environment without additional styling.

The complete documentation of the new quote environment is as follows.

```latex
\begin{quote}[quote width][top margin]{name of cited person}[extra information about cited person]
    ...
\end{quote}
```

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
subsection](#font-installation-on-windows-MiKTeX). If you encounter a problem,
do not hesitate to open an [issue](https://github.com/Caster/Beamer-TUe/issues).
In case there is a problem with Beamer-TUe, you are welcome to open a [pull
request](https://github.com/Caster/Beamer-TUe/pulls).

  1. [Download](https://github.com/Caster/Beamer-TUe/raw/master/TUe-fonts/latex_huisstijl.zip)
the `latex_huisstijl.zip` ZIP archive from the `TUe-fonts` folder in the
repository. You can skip this step if you cloned the repository.

  2. There are now two options. You can install the font system-wide, or only
for your local user. If you have root access, we recommend the system-wide
installation.

     1. *(system-wide)* Find out where your system-wide local `texmf` directory
         is located. You can do so by executing (need not be run as root):

         <pre><b>$</b> kpsewhich --var-value TEXMFLOCAL</pre>

         If this does not give any output, then the value is not set. You can set
         it to any directory you like using the below command. Normally, this
         directory will be `/usr/local/texlive/texmf-local` or
         `/usr/local/share/texmf` for example.

         <pre><b>$</b> tlmgr conf texmf TEXMFLOCAL /usr/local/share/texmf</pre>

         You can now unzip the archive in this local `texmf` directory, possibly
         creating the directory if it does not exist yet.

     2. *(single user)* Unzip the archive in a `texmf` directory in your home
         folder, so `~/texmf`. If this `texmf` folder does not exist yet, you can
         create it. The name and location of this folder are important, because
         your LaTeX distribution will look in this directory for fonts and
         packages.

  3. The next step is to let LaTeX know that you installed a font. Again, there
are two options depending on if your installation is system-wide or not.

     1. *(system-wide)* Open a command line and run the following commands (if you
         do not have `sudo` installed, run them as root, so `su` before you start
         them and without `sudo` per command):

        <pre><b>$</b> sudo mktexlsr
<b>$</b> sudo updmap-sys --enable Map=tue.map
<b>$</b> sudo updmap-sys</pre>

     2. *(single user)* Open a command line and run the following command (not as
         root):

         <pre><b>$</b> updmap --enable Map=tue.map</pre>

Congratulations, you should now be able to use the `zmb` font family in LaTeX
and use the TU/e font! Do not forget to `\usepackage[T1]{fontenc}` however.

#### Troubleshooting
Make sure LaTeX can find the TU/e fonts by executing the following command, that
should output the path to your `texmf` directory followed by `fonts/map/tue.map`.
Example output is provided below.

<pre>
<b>$</b> kpsewhich tue.map
/usr/local/share/texmf/fonts/map/tue.map
</pre>

If this command does not give any output, make sure your `texmf` directory is
known by LaTeX. Check if it is listed in the output of (again, sample output)

<pre>
<b>$</b> tlmgr conf 2>&1 | grep '^TEXMF[LH]'
TEXMFLOCAL=/usr/local/share/texmf
TEXMFHOME=/home/thom/texmf
</pre>

If not, use `tlmgr conf texmf TEXMFLOCAL /usr/local/share/texmf`, substituting
the variable and path to what you need, to set either `TEXMFLOCAL` (for
system-wide installations) or `TEXMFHOME` (for single user installations) to the
path to your `texmf` directory.

### Font installation on Windows (MiKTeX)
Installing the TU/e font on Windows in such a way that LaTeX can use it is
slightly more elaborate than on Linux and Mac, but it should be easy to follow
the steps in this section to make it work. The steps are taken from [this answer
at TeX.SE](http://tex.stackexchange.com/a/95456/23145), but has been changed so
that it specifically targets the TU/e font installation, instead of Frutiger.

#### Create a local TeXMF tree
LaTeX packages, fonts, document classes and related files are stored in a
specific way in a directory that is called a TeXMF tree. You can have more than
one TeXMF tree on your system and your LaTeX installation will check them in
order to find packages, fonts, et cetera. If you do not have one yet, you should
create one and let MiKTeX know where it is.

First, create a folder. This can be any folder (but avoid spaces in the path
name and do not select a folder in your MiKTeX installation), we will
use`C:\localtexmf` as an example in this README. The subtrees you need depend on
what you want to install into this directory, but in our case it should be
sufficient to create the following directories:

    C:\localtexmf\doc\latex
    C:\localtexmf\tex\latex

Again, `C:\localtexmf` can be any path. Now go to MiKTeX's *Settings (Admin)* in
the Start Menu, click on the *Roots* tab and add `C:\localtexmf` (or your custom
path). Next click on the *General* tab and click on *Refresh FNDB*.

Excellent more detailed instructions for the creation of a local TeXMF tree in
MiKTeX can be found [on TeX.SX](http://tex.stackexchange.com/a/69484/14497).

#### Install fonts
[Download](https://github.com/Caster/Beamer-TUe/raw/master/TUe-fonts/latex_huisstijl.zip)
the `latex_huisstijl.zip` ZIP archive from the `TUe-fonts` folder in the repository
and unpack it in your `C:\localtexmf` folder (or copy its contents there). This
means that for example the file

    fonts\map\tue.map

would go in `C:\localtexmf\fonts\map`, the folder

    fonts\tfm\tue\huisstyl

would go in `C:\localtexmf\fonts\tfm\tue\huisstyl`, et cetera.

Now be sure to close any programs related to MiKTeX. This can be MiKTeX's
*Settings (Admin)* window if you just created a local TeXMF tree, TeXworks, et
cetera. These programs can lock files that we need to edit, hence they need to
be closed,

Next, on the Windows command prompt, type

    initexmf --admin --edit-config-file updmap

then add the line

    Map tue.map

and save. Afterwards, run

     initexmf -u
     initexmf --mkmaps

Finally, refresh the FNDB. You can do so in the *General* tab of MiKTeX's
*Settings (Admin)*. Try running `kpsewhich tue.map` on the Windows command
prompt. It should return the location of the map file; if it doesn't, somehow it
is not visible to TeX. Otherwise, you are done and are now able to use the `zmb`
font family in LaTeX and use the TU/e font! Do not forget to
`\usepackage[T1]{fontenc}` however. All examples in this repository use the
`zmb` font family and hence should look better after you have done all this.
