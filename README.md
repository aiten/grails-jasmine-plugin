Grails plugin to run jasmine BDD specs from grails project
================

In this 1.0 release of the plugin you can run jasmine tests from command line by using "grails run-jasmine".
The "grails run-jasmine-ci" command should also work but I am still trying to figure out how to get the 
report back from jasmine in a meaningful format.

How this works?
===============
I am using JRuby to invoke jasmine ruby gem from the plugin. I know its crazy but it works :)

How to Start?
===============
* Install the grails plugin
* Before running the plugin make sure to set the JRUBY_HOME

How to Upgrade Jasmine?
=======================
* Simply download the plugin source from http://github.com/aiten/grails-jasmine and run:
'grails package-jasmine'

Check in the results and either build the plugin yourself, or submit a pull request with the new Jar :)

