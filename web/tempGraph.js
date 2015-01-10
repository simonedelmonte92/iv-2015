// TEMPORAL ANALYSIS GRAPH
(function tempGraph() {
    var margin = {top: 20, right: 0, bottom: 20, left: 20};
    var width = 600;
    var height = 440;

    var g = new Graph(margin, width, height, "#temp-graph", 1);
    g.xAxis = g.xAxis.tickFormat(d3.time.format("%Y"));

    d3.csv("temp-data.csv", function (error, data) {

        var parseDate = d3.time.format("%Y").parse;

        data.forEach(function (d) {
            d.date = parseDate(d.date);
            d.value = +d.value;
        });

        g.x.domain(data.map(function (d) {
            return d.date;
        }));
        g.y.domain([0, 10]);
        g.svg.append("g")
            .attr("class", "x axis")
            .attr("transform", "translate(0," + g.height + ")")
            .call(g.xAxis)
            .selectAll("text")
            .style("text-anchor", "end")
            .attr("dx", "-.8em")
            .attr("transform", "rotate(-45)");

        g.svg.append("g")
            .attr("class", "y axis")
            .call(g.yAxis)
            .append("text")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", ".71em");

        var line = d3.svg.line()
            .x(function (d) {
                return g.x(d.date);
            })
            .y(function (d) {
                return g.y(d.value);
            })
            .interpolate("linear");

        g.svg.append("path")
            .attr("d", function (d) {
                return line(data)
            })
            .attr("transform", "translate(0,0)")
            .style("stroke-width", 2)
            .style("stroke", "#983131")
            .style("fill", "none");

        g.svg.selectAll("bar")
            .data(data)
            .enter().append("svg:circle")
            .attr("cy", function (d) {
                return g.y(d.value);
            })
            .attr("cx", function (d, i) {
                return g.x(d.date);
            })
            .attr("r", 6)
            .style("opacity", 1)
            .style("fill", "#BE1818");
    });
})();