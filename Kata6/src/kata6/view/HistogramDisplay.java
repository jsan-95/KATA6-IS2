package kata6.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{
    private final Histogram <T> histogram;

    public HistogramDisplay(Histogram<T> histogram) {
        super("HISTOGRAM");
        this.histogram = histogram;
        
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel(){
        ChartPanel panel = new ChartPanel( createChart(createDataSet()));
        panel.setPreferredSize(new Dimension(500, 400));
        return panel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart3D("JFreeChart Histogram", 
                                                         "Dominios email", 
                                                         "Número de emails",
                                                         dataSet,
                                                         PlotOrientation.VERTICAL, 
                                                         true, 
                                                         true, 
                                                         true
        );
        chart.setBackgroundPaint(Color.YELLOW);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.darkGray);
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.green);
        renderer.setSeriesPaint(1, Color.green);
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
        
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key),"", (Comparable) key);
        }
        
        return dataSet;
    }
    
    public void execute(){
        setVisible(true);
    }
}
