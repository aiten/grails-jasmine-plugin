grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"

// Temporary, client's repository until I have had contact from the original author.
grails.release.scm.enabled = false
grails.plugin.repos.discovery.sky = 'http://plugins.id.bskyb.com/svn'
grails.plugin.repos.distribution.sky = 'http://plugins.id.bskyb.com/svn'
grails.project.repos.default = 'sky'

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

}
