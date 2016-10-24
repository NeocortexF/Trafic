/*
 * Красный сигнал светофора
 */
package trafficlight;

import javax.swing.ImageIcon;

/**
 *
 * @author NeocortexF
 */
public class RedLight extends Lamp {

    @Override
    ImageIcon getLampColor() {
        ImageIcon iconRed = new ImageIcon(getClass().getResource("/trafficlight/Images/red.png"));
        return iconRed;
    }
    
}
