package graphics.shapes.ui;

import graphics.shapes.ShapeModel;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Editor extends JFrame
{
	ShapesView sview;
	BannerView bview;
	ShapeModel model;
	
	public Editor()
	{
		super("Pain-t-");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		this.model = new ShapeModel();
		
		this.bview = new BannerView(this.model);
		this.getContentPane().add(this.bview, java.awt.BorderLayout.SOUTH);

		
		this.sview = new ShapesView(this.model, this.bview.getController());
		this.sview.setPreferredSize(new Dimension(300,300));
		this.model.register(new ShapesObserver(this.sview));
		
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
	}


	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);
	}
}
