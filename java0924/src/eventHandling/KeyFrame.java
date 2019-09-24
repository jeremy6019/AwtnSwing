package eventHandling;

import java.awt.Frame;
import java.awt.Label;

public class KeyFrame extends Frame {
    Label lbl;
	public KeyFrame() {
    	setLayout(null); 
    	
    	//레이블을 생성해서 배치 
    	lbl = new Label("^@^"); 
    	lbl.setBounds(20, 40, 30, 30);
    	add(lbl); 
    	
    	// Frame에 윈도우 이벤트가 발생하면 
    	// EventHandler 객체에게 처리해달라고 요청 
    	EventHandler eventHandler =
    			new EventHandler(lbl);
    	this.addWindowListener(eventHandler);
    	this.addKeyListener(eventHandler);
    	 	
    	setBounds(200,200, 500,500); 
    	setTitle("키보드와 윈도우 이벤트 처리 "); 
    	setVisible(true); 
    }
}
