IntelliJ IDEA / PhpStorm Neos Plugin
====================================
[![Build Status](https://travis-ci.org/cvette/intellij-neos.svg?branch=master)](https://travis-ci.org/cvette/intellij-neos)
[![Version](https://christianvette.de/badge/9362/version)](https://plugins.jetbrains.com/plugin/9362)
[![Downloads](https://christianvette.de/badge/9362/downloads)](https://plugins.jetbrains.com/plugin/9362)
[![Downloads last month](https://christianvette.de/badge/9362/last-month)](https://plugins.jetbrains.com/plugin/9362)
[![Gitter](https://img.shields.io/gitter/room/nwjs/nw.js.svg)](https://gitter.im/intellij-neos/Lobby)

This is a **work in progress**. There may be performance and stability problems.

Features
--------

* Fusion / TypoScript2 language support
 * Configurable syntax highlighting
 * Basic formatting
 * Brace matching
 * Breadcrumb navigation
 * Code folding
 * Structure view
 * EEL helper references (Ctrl+Click navigation to class/method)
* Completion for node type definitions

Usage
-----
You can install the plugin by going to `Settings > Plugins > Browse repositories` and searching for "Neos".

Developing
----------

- clone the repository
- run `./gradlew runIde` - for the first time, this will take quite a while, as it downloads IntelliJ
- to open the project in IntelliJ, Use "File -> Open" in IntelliJ and select the "build.gradle" in here.
- have fun developing :)

Development Tips and Tricks
---------------------------

- install GrammarKit if you want to work on the parser

License
-------
Copyright (C) 2016  Christian Vette

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.
