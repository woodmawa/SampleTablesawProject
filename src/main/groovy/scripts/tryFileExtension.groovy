package scripts

File f = File.getFileFromResource("someFile.txt")
assert f.exists()

println f.text