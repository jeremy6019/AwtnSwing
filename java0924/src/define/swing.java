package define;

public class swing {
/*
 **Swing 
 => JDK가 제공하는 자원을 이용해서 GUI프로그래밍
 => 대부분은 AWT클래스로부터 상속을 받고 클래스 이름의 시작은 대문자 J
 => 컴포넌트에 보더(경계선)를 설정 가능  
 => Container에 pack이라는 메소드가 있어서 배치된 컴포넌트 크기에 맞춰서 Container크기를 조절할 
 수 있습니다. 
 => JFrame(Frame) , JPanel(Panel), JScrollPane(ScrollPane)
 =>setTooltipText(텍스트나 html)을 이용하면 마우스가 올라왔을때 툴팁을 출력 
 
 1.JLabel 
 =>텍스트나 이미지를 출력해주는 컴포넌트 
 => 레이블을 만들때 Icon객체를 주면 이미지를 출력하고 String을 주면 문자열을 출력 
 /Users/a503-22/Documents/java\ application/99845E495D89880006.png 
  2. 파일 경로 설정 
  1) 절대경로: 루트로부터의 전체경로 
  
  2) 상대경로: 현재 위치로부터의 경로 
  ./ : 현재 디렉토리
  ../ : 상위 디렉토리 
 
 3.Icon클래스의 객체 생성 
 new ImageIcon("그림파일 경로")
  
 4. 버튼 만들어서 시작과 중지를 해보는데 하나의 버튼을 가지고 시작과 중지 기능을 생성 
 boolean flag = false; 
 
  btn.addActionListener(new ActionListener(){
      public void actionPerformed(actionEvent e){
          if(flag == false) {시작}
          else {중지}
          flag = !flag;
      } 
  });
  
  =>이미지 파일을 저장하고 이미지파일을 이용해서 레이블에 출력: 파일의 경로를 정확하게 설정 확인
  => 스레드를 이용해서 이미지를 교체: 스레드는 반드시 만들 수 있어야 합니다. 
  =>버튼 1개를 가지고 스레드를 시작시키고 종료시키는 작업을 생성: 토글을 만들 수 있어야 합니다. 
  
 **Button 
 =>JButon, JToggleButton, JCheckBox,JRadioButton등이 있음 
 =>JRadioButton은 ButtonGroup이라는 클래스의 객체에게 add해서 그룹화를 합니다. 
 하나의 그룹을 만들고자 할 때는 동일한 ButtonGroup에 add를 하면 됩니다. 
 
  **JTextField 
  =>한 줄의 문자열을 입력하기 위한 컴포넌트 
  => caret이 입력할 때 반짝이는 커서 
  
  **JPasswordField 
  =>비밀번호 입력을 위한 컴포넌트 
  =>EchoChar:입력할 때 보여지는 글자 
  
   **JTextArea 
   =>여러 줄 입력을 위한 컴포넌트 
 
*JComboBox 
=>여러 개의 항목 중에서 하나를 선택할 수 있도록 해주는 컴포넌트 
=> 생성할 때는 데이터 배열이나 벡터를 대입해서 생성 
=> addItem, removeItem, insertItem같은 메소드로 항목을 추가하거나 삭제할 수 있습니다. 
=>setEditable(true)를 호출하면 항목을 편집할 수 있습니다. 

**JList
=> 여러개의 항목 중에서 하나 도는 여러개를 선택할 수 있도록 해주는 컴포넌트 
=> 생성은 배열이나 벡터를 대입해서 생성 
=> getSelectedIndex()를 이용해서 선택한 항목 한 개의 인덱스를 리턴받을 수 있고  
getSelectedIndexes()를 이용하면 선택한 모든 항목의 인덱스를 리턴받을 수 있습니다. 

=>JComboBox와 JList에서 중요한 것은 선택한 항목을 찾아오는 것입니다.
출력할 데이터는 배열이나 벡터를 외부에 만들어서 사용 
필요한 배열이나 벡터에서 인덱스를 이용해서 데이터를 찾아오도록 해야합니다. 

**JTable 
=>데이터를 행과 열로 분할해서 출력해주는 컴포넌트 
=> MVC패턴으로 구현 
=> 화면 출력을 담당하는 JTable과 이 Table에 데이터를 공급하는 TableModel로 나누어서 구현 
=> JTable을 구현할 때 TableModel을 대입해서 생성해도 되고 먼저 JTable을 만든 후 TableModel을 
setModel()에 대입해서 설정해도 됩니다. 
=>JTable은 JScrollPane위에 배치해야 스크롤바가 생기고 컬럼이름도 출력이 됩니다. 
JTable은 ScrollPane위에 배치하지 않으면 컬럼이름이 출력되지 않습니다. 
=>JTable에서 선택된 행 번호는 getSelectedrow()메소드로 리턴받을 수 있습니다.
=>데이터 추가나 삭제는 JTable에 하는 것이 아니고 JTable의 getModel()을 이용해서 가져온 TableModel
에 추가하거나 삭제합니다.
addRow(String[] row)을 이용해서 데이터를 추가 
removeRow(int idx) 을 이용해서 idx번째 데이터를 삭제 
=> 테이블에 초기데이터를 삽입하기 위해 필요한 데이터 
컬럼이름 배열(1차원)과 데이터 배열(2차원) 

 번호, 이름, 나이, 전화번호를 출력하는 테이블을 만들고 편집할 수 있도록 하기 
 {"번호","이름","나이","전화번호"}
 
  {{ "1","김 ",27","010 "},{ "2","이","나이","전화번호"}}
 
 => 데이터를 삽입할 때는 유효한 데이터인지 확인하고 삽입 - 유효성 검사 
 이름은 생략불가능 
 나이도 생략 불가능 
 주소도 생략 불가능 
 이름은 3자이상 
 
 =>데이터를 삭제할때는 정말로 삭제할 것인지 한 번 정도 묻고 삭제 
  
 =>메세지박스 출력 
 JOptionPane.showMessageDialog(null, 제목, 메시지, 모양);
 모양은 JOptionPane.INFORMATION_MESSAGE 
  
** 상대경로를 이용해서 이미지 파일을 레이블에 출력 
ImageIcon icon = new ImageIcon("아이콘 파일 위치");
JLabel lbl = new JLabel(icon);

  ** 위의 문장을 성공하면 1초마다 숫자를 1부터 증가하면서 출력하는 스레드를 생성하고 
   시작숫자를 출력하는 것을 성공하면 이미지를 번갈아 가면서 출력 
  
  
  
 
 */
}
