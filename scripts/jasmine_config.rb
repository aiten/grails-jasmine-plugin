class Jasmine::Config

  attr_accessor :dynamic_spec_dir
  attr_accessor :project_root

  def project_root
    @project_root
  end

  def simple_config
     config = File.exist?(simple_config_file) ? YAML::load(ERB.new(File.read(simple_config_file)).result(binding)) : false
     config || {}
  end

  def simple_config_file
     File.join(project_root, 'test/jasmine/spec/javascripts/support/jasmine.yml')
  end

  def spec_dir
    if simple_config['spec_dir']
      File.join(project_root, simple_config['spec_dir'])
    else
      File.join(dynamic_spec_dir, 'spec/javascripts')
    end
  end

  def js_files(spec_filter = nil)
    spec_files_to_include = spec_filter.nil? ? spec_files : match_files(spec_dir, [spec_filter])
    src_files.collect {|f| "/" + f } + helpers.collect {|f| File.join(spec_path, f) } + spec_files_to_include.collect {|f| File.join(spec_path, f) }
  end
end