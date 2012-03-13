import org.jruby.embed.PathType

includeTargets << grailsScript("_GrailsArgParsing")

USAGE = """
    jasmine [--prefix=PREFIX]

where
    PREFIX = The prefix to add to the names of the realm and domain classes.
             This may include a package. (default: "Shiro").
"""

target(default: "Runs the jasmine server") {
  def c = new org.jruby.embed.ScriptingContainer()

  def script = """
                  require 'rubygems'
                  require 'jasmine'

                  jasmine_config_overrides = '${jasminePluginDir}/scripts/jasmine_config.rb'
                  require jasmine_config_overrides if File.exist?(jasmine_config_overrides)

                  puts "Tests running at: http://localhost:8888/"

                  config = Jasmine::Config.new
                  config.dynamic_spec_dir = File.join('${basedir}', 'test/jasmine/spec')
                  config.start_server
               """
  c.runScriptlet(script)
}
