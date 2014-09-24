Beamer-TUe
==========
An extension of the TU/e theme for the LaTeX Beamer class.

Table of contents
-----------------
* [Usage instructions](#usage)
* [Options for the theme](#options)
* [TU/e font installation](#font-installation)

<a name="usage"></a>Usage instructions
--------------------------------------
After cloning the repository or downloading a tarball from GitHub, you need to 
grab the contents of the `theme` directory and put that in the same directory as 
where your main TeX source file is located. After that, you should be able to 
use the TU/e Beamer theme in your Beamer presentation using the following lines:

```
\usetheme[department=winuk,official=false,theme=cyan,innovation=false]{tue2008}
\mode<presentation>
```

It is probably best to put these lines right after your `\usepackage` 
declarations, which in turn should come after the

```
\documentclass[12pt, aspectratio=169]{beamer} % aspectratio = 43 of 169
```

line at the top of your TeX source file.

<a name="options"></a>Theme options
-----------------------------------
The theme supports the following options, which can be passed to it in the usual 
way: in the `\usetheme` line (refer to [Usage instructions](#usage)). All 
options are key/value pairs. Most options were present in the original TU/e 
theme, but they are documented here too for completeness.

| Option key | Default value | Possible values | Option description |
| ---------- | ------------- | --------------- | ------------------ |
| theme      | red           | red, cyan, blue, green, orange | Used to change 
the colour theme of all slides. |
| department | none          | none, ele, eleuk, win, winuk, bmt, bmtuk, bwk, 
bwkuk, id, iduk, chem, chemu, tm, tmuk, phys, physu, wtb, wtbuk | Used to change 
the deparment at the bottom of all slides. For example, 'winuk' will render 
'department of mathematics and computer science' on every slide. |
| statustext | (empty string) | Any string. | Text to put right after the 
department. Can be used to specify a custom value for the department, in 
conjuction with using 'none' for the department option. |
| titlelogo | (empty string) | Any string. | Optional path to an image file, for 
inclusion on the title slide. |
| titlebgimage | (empty string) | Any string. | Optional path to an image file, 
for inclusion on the title slide. This image will be put in the background, 
spanning the entire visible height of the slide and right aligned. |
| titlebgimagetransparency | 0.65 | Number between 0 and 1. | The transparency 
of the block in theme colour that forms the background of the title on the title 
slide, but sits in front of the background image (if specified). |
| compress | false | n.a. | Pass this option without a value to enable the 
Beamer compress flag. |
| official | false | true, false | Will trigger some styling differences when 
used. It is recommended to not use this option normally. |
| innovation | true | true, false | If the slogan 'where innovation starts' 
should be printed on the title slide. |
| realpagenumbers | false | true, false | If apart from the slide number, the 
page number should be put on every slide. |
| tocslides | false | true, false | If at the start of every `\section`, a slide 
should be inserted with a table of contents in which the section is highlighted. 
|
| slidesperpage | 1 | Any positive integer. | The number of slides to put per 
page. When handout is used, this value is set to 2 and cannot be overridden. |

<a name="font-installation"></a>TU/e font installation
------------------------------------------------------
You may notice that the font is incorrect (and there may be warnings coming from 
LaTeX telling you so). In that case, you probably need to install the TU/e font 
in such a way that LaTeX can use it. On Linux, you can do so as follows below. 
On Windows and Mac, the procedure is probably similar, but as I (the developer) 
cannot test on those platforms, documentation is lacking. Please open an issue 
(preferably with a pull request) with extra information if you are able to test 
on some other platform, or find an error in the documentation here.

1. Download the `latex_huisstijl.zip` ZIP archive from the `TUe-fonts` folder in 
the repository. You can skip this step if you cloned the repository.
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

