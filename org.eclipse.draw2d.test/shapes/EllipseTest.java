
import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class EllipseTest {

public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell();
	
	LightweightSystem lws = new LightweightSystem(shell);
	
	Figure panel = new Figure();
	panel.setLayoutManager(new FlowLayout());
	panel.setBackgroundColor(ColorConstants.white);

	MouseMotionListener listener = new MouseMotionListener.Stub() {
		public void mouseEntered(MouseEvent me) {
			((Shape)me.getSource()).setBackgroundColor(ColorConstants.yellow);
		}
		public void mouseExited(MouseEvent me) {
			((Shape)me.getSource()).setBackgroundColor(ColorConstants.white);
		}
	};

	for (int i=1; i <= 4; i++){
		Ellipse e = new Ellipse();
		e.setFill(true);
		e.setPreferredSize(new Dimension (20 + 10*i + i%2, 60 - 10*i + i/2));
		e.addMouseMotionListener(listener);
		panel.add(e);
	}
	
	lws.setContents(panel);
	shell.setSize(400,300);
	shell.open();
	
	while (!shell.isDisposed())
		if (!display.readAndDispatch())
			display.sleep();

}

}
