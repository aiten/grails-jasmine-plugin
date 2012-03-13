grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

grails.project.dependency.resolution = {

    inherits( "global" ) {
    }

    log "warn"

    repositories {        
        grailsPlugins()
        grailsHome()

        mavenLocal(null)
        mavenCentral()


    }
    dependencies {

        runtime 'org.jruby:jruby-complete:1.6.7'
        
    }
    plugins {

        build ':release:1.0.1', {
            export = false
        }

    }

}
