/**
 * Copyright 2015-2017 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2011-2015 Xeiam LLC (http://xeiam.com) and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.knowm.xchart.internal.chartpart;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.knowm.xchart.RadarSeries;
import org.knowm.xchart.internal.series.Series;
import org.knowm.xchart.style.RadarStyler;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Plot_Radar<ST extends Styler, S extends Series> extends Plot_ {

  /**
   * Constructor
   *
   * @param chart
   */
  public Plot_Radar(Chart<RadarStyler, RadarSeries> chart) {

    super(chart);
    this.plotContent = new PlotContent_Radar<RadarStyler, RadarSeries>(chart);
    this.plotSurface = new PlotSurface_Radar<RadarStyler, RadarSeries>(chart);
  }

  @Override
  public void paint(Graphics2D g) {

    // calculate bounds
    double xOffset = chart.getStyler().getChartPadding();

    // double yOffset = chart.getChartTitle().getBounds().getHeight() + 2 * chart.getStyler().getChartPadding();
    double yOffset = chart.getChartTitle().getBounds().getHeight() + chart.getStyler().getChartPadding();

    double width =

        chart.getWidth()

            - (chart.getStyler().getLegendPosition() == LegendPosition.OutsideE ? chart.getLegend().getBounds().getWidth() : 0)

            - 2 * chart.getStyler().getChartPadding()

            - (chart.getStyler().getLegendPosition() == LegendPosition.OutsideE && chart.getStyler().isLegendVisible() ? chart.getStyler().getChartPadding() : 0);

    double height = chart.getHeight() - chart.getChartTitle().getBounds().getHeight() - 2 * chart.getStyler().getChartPadding();

    this.bounds = new Rectangle2D.Double(xOffset, yOffset, width, height);

    super.paint(g);
  }
}
