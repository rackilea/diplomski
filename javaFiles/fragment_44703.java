ENV['DATABASE'] ||= 'hsql' # this line makes the default 'hsql'

define "foo" do
  # the rest of the definition

  resources.enhance do
    cp _(:source, :main, :resources, "database-#{ENV['DATABASE']}.properties"), _(:target, :resources, "database.properties")
  end
end