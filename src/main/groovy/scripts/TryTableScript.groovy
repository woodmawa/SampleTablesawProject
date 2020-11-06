package scripts

import tech.tablesaw.api.*
import tech.tablesaw.columns.Column

import java.nio.file.Path
import java.nio.file.Paths

import static utils.FileUtils.getFileFromResource

File inp

//this resolves to file:///D:/Intellij-projects/SampleTablesawProject/src/main/groovy/scripts/testFile.txt
Path p = Paths.get "testFile.txt"
File f = p.toFile()
def uri = p.toUri()
println "abs path : " + f.absolutePath

//this doesnt work !
/*def url = GroovyClassLoader.getResource("testFile.txt")
Path p1 = Paths.get (url.toURI())
*/




//        inp = File.getResource("testFile.txt")

//inp = FileUtils.getFileFromResource("testFile.txt")

//static import to get a resource from classpath
inp = getFileFromResource ("testFile.txt")
assert inp.exists()

Table df = Table.read().csv(inp)


StringColumn sc = StringColumn.create("processed")

// dataframe must have columns of equal size (same number of rows)
def rows = df.rowCount()
rows.times  {
    sc.appendCell("processed value $it")
}


df.addColumns(sc)


println "count of rows " + df.rowCount()
println "count of columns " + df.columnCount()
println df.printAll()
println "structure : \n" + df.structure()

println "\nrows  iteration..."
for (Row row in df) {
    print row.getText(0) + " : " + row.getText(1)
    println "  > first column type is " + row.getColumnType("hello").printerFriendlyName
}

println "\ncolumns iteration..."
for (Column col in df.columnArray()) {
    println col.name()
}


