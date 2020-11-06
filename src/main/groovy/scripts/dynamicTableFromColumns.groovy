package scripts

import tech.tablesaw.api.IntColumn
import tech.tablesaw.api.StringColumn
import tech.tablesaw.api.Table
import tech.tablesaw.columns.Column

Column sc1 = StringColumn.create ("String column1", "hello", "there")
Column ic2 = IntColumn.create ("Integer column2", 1, 2)

//seems to defined by columns at point of adding, appending to column doesnt change the dataframe 2x2
Table df = Table.create(sc1, ic2)

println df.shape()
println df.structure()
println df.printAll()

//cant create
ic2.append(3)
println ic2.print()

//add empty cell ref to column
sc1.appendMissing()

//this is ok as columns still have same length
Table df2 = Table.create(sc1, ic2)
println df2.shape()
println df2.structure()
println df2.printAll()

