/*
 * Домашнее задание: Евгений Шамкин
 * Программа светофор для курса Java Web
 * Класс пользовательский UI + контроллер (  = божественный класс... наверное так нельзя делать... :)) 
 * 
 */
package trafficlight;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author NeocortexF
 * @date 24.10.2016
 */
public class TrafficUI extends javax.swing.JFrame {
    
    // Объявление локальных переменных
    Timer timerRed;
    Timer timerYellow;
    Timer timerGreen;
    ImageIcon iconOff = new ImageIcon(getClass().getResource("/trafficlight/Images/off.png"));

    /** Констуктор UI */
    public TrafficUI() {
        
        initComponents();
        setTrafficLightOff();
        
        //обработчик события на нажатие кнопки
        event e = new event();
        bStart.addActionListener(e);     
    }
    
    private void setTrafficLightOff(){
        // установка светофора в выключенное состояние
        lRed.setIcon(iconOff);
        lGreen.setIcon(iconOff);
        lYellow.setIcon(iconOff);
    }
           
    //вложенный класс установки и запуска секундомера 
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            //проверка заполнения полей пользователем
            if(tfRed.getText().equals("") || tfYellow.getText().equals("") || tfGreen.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Пожалуйста, задайте время работы всех сигнальных фонарей светафора!");        
            } else {          
                    trafficLightOn();          
            }
        }
        
        void trafficLightOn() {
            int count = (int) (Double.parseDouble(tfRed.getText()));
            timerLabelRed.setText("Еще горит: " + count);

            //загорелся красный
            RedLight rl = new RedLight();
            lRed.setIcon(rl.getLampColor());

            TimeClassRed tcRed = new TimeClassRed(count);

            // 1000 милисекунд = 1 секунде - внутреняя атомарная интовая, можно ускорить или замедлить
            timerRed = new Timer(1000, tcRed);
            timerRed.start();

            // желтый
            int countY = (int) (Double.parseDouble(tfYellow.getText()));
            timerLabelYellow.setText("В ожидании: " + countY);
            TimeClassYellow tcYellow = new TimeClassYellow(countY);
            timerYellow = new Timer(1000, tcYellow);
            timerYellow.setInitialDelay(count * 1000);
            timerYellow.start();

            // зеленый
            int countG = (int) (Double.parseDouble(tfGreen.getText()));
            timerLabelGreen.setText("В ожидании: " + countG);
            TimeClassGreen tcGreen = new TimeClassGreen(countG);
            timerGreen = new Timer(1000, tcGreen);
            timerGreen.setInitialDelay((count * 1000)+(countY * 1000));
            timerGreen.start();
        }
    }
     
     public class TimeClassRed implements ActionListener {
        //вложенный класс работы отчета секундомера красного фонаря
        int counter;
        
        public TimeClassRed(int counter) {
            this.counter = counter;
        }
        
        public void actionPerformed(ActionEvent tcRed) {
           //обратрый отчет таймера и выключение красного фонаря
            counter--;
            
            if(counter >= 1) {
                timerLabelRed.setText("Еще горит: " + counter);
                
            } else {
                timerRed.stop();
                timerLabelRed.setText("Выключен!");
                lRed.setIcon(iconOff);    
            } 
        }  
    }
     
     public class TimeClassYellow implements ActionListener {
        //вложенный класс работы отчета секундомера желтого фонаря
        int counter;
        
        public TimeClassYellow(int counter) {
            this.counter = counter;
        }
        
        public void actionPerformed(ActionEvent tcYellow) {
           //обратрый отчет таймера и выключение желтого фонаря
            counter--;
            
            if(counter >= 1) {
                timerLabelYellow.setText("Еще горит: " + counter);
                YellowLight yl = new YellowLight();
                 lYellow.setIcon(yl.getLampColor());
                
            } else {
                timerYellow.stop();
                timerLabelYellow.setText("Выключен!");
                lYellow.setIcon(iconOff);    
            } 
        }  
    }
     
    public class TimeClassGreen implements ActionListener {
        //вложенный класс работы отчета секундомера красного фонаря
        int counter;
        
        public TimeClassGreen(int counter) {
            this.counter = counter;
        }
        
        public void actionPerformed(ActionEvent tcGreen) {
           //обратрый отчет таймера и выключение красного фонаря
            counter--;
            
            if(counter >= 1) {
                timerLabelGreen.setText("Еще горит: " + counter);
                GreenLight gl = new GreenLight();
                lGreen.setIcon(gl.getLampColor());
                
            } else {
                timerGreen.stop();
                timerLabelGreen.setText("Выключен!");
                lGreen.setIcon(iconOff);  
            } 
        }  
    }

    // Здесь Netbeans нагенерил код с GUI конструктора
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        timerLabelRed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        timerLabelYellow = new javax.swing.JLabel();
        tfRed = new javax.swing.JTextField();
        tfYellow = new javax.swing.JTextField();
        tfGreen = new javax.swing.JTextField();
        bStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lYellow = new javax.swing.JLabel();
        lGreen = new javax.swing.JLabel();
        lRed = new javax.swing.JLabel();
        timerLabelGreen = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Светофор Евгений NeocortexF");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("traffic.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        timerLabelRed.setText("Ожидание..");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Введите время работы светофора:");

        timerLabelYellow.setText("Ожидание..");

        tfRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRedActionPerformed(evt);
            }
        });

        bStart.setText("Старт");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        lYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trafficlight/Images/yellow.png"))); // NOI18N

        lGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trafficlight/Images/green.png"))); // NOI18N

        lRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trafficlight/Images/red.png"))); // NOI18N

        timerLabelGreen.setText("Ожидание..");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lRed)
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfRed, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timerLabelRed)
                                    .addComponent(timerLabelYellow, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(timerLabelGreen)
                                    .addComponent(bStart)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lGreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lYellow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lRed))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLabelRed))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfYellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLabelYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timerLabelGreen))
                        .addGap(15, 15, 15)))
                .addGap(12, 12, 12)
                .addComponent(bStart)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
  // кнопка старт
    
}//GEN-LAST:event_bStartActionPerformed

private void tfRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRedActionPerformed
// создал конструктор форм Netbeans не дает удалить
}//GEN-LAST:event_tfRedActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bStart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lGreen;
    private javax.swing.JLabel lRed;
    private javax.swing.JLabel lYellow;
    private javax.swing.JTextField tfGreen;
    private javax.swing.JTextField tfRed;
    private javax.swing.JTextField tfYellow;
    private javax.swing.JLabel timerLabelGreen;
    private javax.swing.JLabel timerLabelRed;
    private javax.swing.JLabel timerLabelYellow;
    // End of variables declaration//GEN-END:variables
}
