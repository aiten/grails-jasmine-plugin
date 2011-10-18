//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

String gemTempDir = './target/jasmine-gems'
String jruby =  grailsSettings.$defaultTestDependencies.find { it.absolutePath.contains('jruby-complete') }

target(default: "Package jasmine") {

    ant.exec(executable: "java", failonerror: true) {
           arg line: "-jar ${jruby} -S gem install -i ${gemTempDir} jasmine --no-rdoc --no-ri"
    }

    ant.exec(executable: "jar", failonerror: true) {
        arg line: "cf lib/jasmine-gems.jar -C ${gemTempDir} ."
    }

}