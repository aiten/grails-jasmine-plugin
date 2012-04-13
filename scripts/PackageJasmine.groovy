String gemTempDir = './target/jasmine-gems'
String jruby =  grailsSettings.$defaultTestDependencies.find { it.absolutePath.contains('jruby-complete') }

target(default: "Package jasmine") {

    ant.exec(executable: "java", failonerror: true) {
           arg line: "-jar ${jruby} -S gem install -i ${gemTempDir} jasmine --no-rdoc --no-ri"
    }

    ant.exec(executable: "java", failonerror: true) {
           arg line: "-jar ${jruby} -S gem install -i ${gemTempDir} jruby-openssl --no-rdoc --no-ri"
    }

    ant.delete(file: "target/jasmine-gems/gems/rack-1.4.1/lib/rack/file.rb")
    ant.copy(file: 'src/resources/rackPatch/file.rb', todir: 'target/jasmine-gems/gems/rack-1.4.1/lib/rack')

    ant.exec(executable: "jar", failonerror: true) {
        arg line: "cf lib/jasmine-gems.jar -C ${gemTempDir} ."
    }

}