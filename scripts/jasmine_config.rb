class Jasmine::Config

  attr_accessor :dynamic_spec_dir

  def project_root
    File.expand_path(File.join(File.dirname(__FILE__), ".."))
  end

  def src_files
    filesSrc = match_files(project_root, "/web-app/js/*.js")
    filesTest = match_files(project_root, "/test/**/*Helper.js")
    filesSrc + filesTest
  end  
  
  def spec_dir
     @dynamic_spec_dir
  end
end