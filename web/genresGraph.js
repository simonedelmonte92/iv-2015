// GENRE GRAPH
(function genreGraph() {
    var margin = {top: 20, right: 0, bottom: 20, left: 20};
    var width = 660;
    var height = 300;

    var g = new Graph(margin, width, height, "#genre-graph", 0.1);

    d3.csv("genre-data.csv", function (error, data) {

        data.forEach(function (d) {
            d.genre = genres[d.genre];
            d.value = +d.value;
        });

        g.x.domain(data.map(function (d) {
            return d.genre;
        }));
        //y.domain([0, d3.max(data, function(d) { return d.value; })]);
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

        g.svg.selectAll("bar")
            .data(data)
            .enter().append("rect")
            .style("fill", "#BE1818")
            .attr("x", function (d) {
                return g.x(d.genre);
            })
            .attr("width", g.x.rangeBand())
            .attr("y", function (d) {
                return g.y(d.value);
            })
            .attr("height", function (d) {
                return g.height - g.y(d.value);
            });
    });
})();