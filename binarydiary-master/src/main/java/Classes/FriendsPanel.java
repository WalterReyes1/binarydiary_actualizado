package Classes;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author Pedro
 */
public class FriendsPanel extends javax.swing.JPanel {
    
    public FriendsPanel(){
        initComponents();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        layout.setAlignOnBaseline(true);
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    public void addFriendRequest(ImageIcon profilePicture, String user, int friendsInCommon){
        this.add(new FriendRequest(profilePicture, user, friendsInCommon));
    }
    
    public void addResult(ImageIcon profilePicture, String user, int friendsInCommon, boolean alreadyFriends){
        this.add(new PersonResult(profilePicture, user, friendsInCommon, alreadyFriends));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(1127, 32767));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
