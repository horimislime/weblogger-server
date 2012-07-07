
<!DOCTYPE html>
<html lang="en">
	<#include "header.ftl">
  <body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Weblogger</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
		<script>
			$(document).ready(function() {
			      new Highcharts.Chart({
			         chart: {
			            renderTo: 'container'
			         },
			         rangeSelector: {
			            selected: 1
			         },
			         title: {
		                text: 'Daily Web Browsing',
		                x: -20 //center
            		},
            		xAxis: {
            			title:{
            				text: "Days"
            			},
            			categories: [
            				<#list keys as key>
            					"${key}",
            				</#list>
            			]
            		},
			         yAxis: {
			         	title:{
			         		text: "view"
			         	}
			         },
			         series: [{
			         		name: "horimislime",
			                data: [
			                <#list values as value>
			                	${value},
			                </#list>
			                ]}]
			      });
			   });
		</script>
		<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto" />
	</div> <!-- /container -->
  </body>
</html>