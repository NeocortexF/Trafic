/*
 * Желтый сигнал светофора
 */
package trafficlight;

import javax.swing.ImageIcon;

/**
 *
 * @author NeocortexF
 */
public class YellowLight extends Lamp {

   @Override
    ImageIcon getLampColor() {
        ImageIcon iconYellow = new ImageIcon(getClass().getResource("/trafficlight/Images/yellow.png"));
        return iconYellow;
    }
    
}
