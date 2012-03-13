class Jasmine::Config

  attr_accessor :dynamic_spec_dir

  def project_root
    File.expand_path(File.join(File.dirname(__FILE__), ".."))
  end

  def src_files
    files = match_files(project_root, "/web-app/js/*.js")
    files
  end  
  
  def spec_dir
     @dynamic_spec_dir
  end
end