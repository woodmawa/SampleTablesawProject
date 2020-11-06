package scripts

import tech.tablesaw.api.DoubleColumn
import tech.tablesaw.selection.Selection

double[] numbers = [1, 2, 3, 4]
DoubleColumn nc = DoubleColumn.create("nc", numbers)
System.out.println(nc.print())

DoubleColumn filtered = nc.where(nc.isLessThan(3D))
println "filtered: \n" + filtered.print()

DoubleColumn filteredPositive = nc.where(nc.isLessThan(3).and(nc.isPositive()))
println "positive filtered: \n" + filtered.print()


println "where with rows : \n" + nc.where(Selection.with(0, 2)).print()

println "where with inclusive rows range 1..3: \n" + nc.where(Selection.withRange(1, 3)).print()

//get a cell
double three = nc.get(2)
assert three == 3

//get new column 4 times the first, you can change the name using setName, default is orig concat with operation
DoubleColumn nc2 = nc.multiply(4)
println(nc2.print())

Selection sel = nc.isLessThan(3)

