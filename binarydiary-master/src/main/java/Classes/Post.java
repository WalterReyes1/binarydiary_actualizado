package Classes;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import org.neo4j.driver.Result;
import org.ocpsoft.prettytime.PrettyTime;

/**
 *
 * @author Pedro
 */
public class Post extends javax.swing.JPanel {

    private Date postDate;
    private String userThatPosted;
    private String postContent;
    private ImageIcon postImage;
    
    private String postID;
    
    /**
     * Creates new form Post
     */
    public Post() {
        initComponents();
    }

    public Post(ImageIcon posterProfilePic, Date postDate, String userThatPosted, String postContent, ImageIcon postImage,String ID) {
        initComponents();
        
        
        this.postDate = postDate;
        this.userThatPosted = userThatPosted;
        this.postContent = postContent;
        this.postImage = postImage;
        this.postID=ID;
        changeLabels(userThatPosted, postContent, processDate(postDate));
        ProfilePicture.setIcon(processImage(posterProfilePic, 60, 60));
        if(postImage==null){
             this.PostImage.setSize(0, 0);
             this.PostImage.setVisible(false);
        }else{
            PostImage.setIcon(processImage(postImage, 400, 400));
        }
        
    }
    
    public Post(ImageIcon posterProfilePic, Date postDate, String userThatPosted, String postContent, String ID) {
        initComponents();
        this.postDate = postDate;
        this.userThatPosted = userThatPosted;
        this.postContent = postContent;
        this.postID=ID;
        changeLabels(userThatPosted, postContent, processDate(postDate));
        this.PostImage.setSize(0, 0);
        this.PostImage.setVisible(false);
        ProfilePicture.setIcon(processImage(posterProfilePic, 60, 60));
    }
    
    private ImageIcon processImage(ImageIcon image, int width, int height){
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_FAST));
    }
    
    private String processDate(Date date){
        PrettyTime p = new PrettyTime(new Locale("es"));
        return p.format(date);
    }
    
    private void changeLabels(String user, String content, String date){
        NameLabel.setText(user);
        PostContent.setText("<html>" + content + "</html>");
        DateLabel.setText(date);
    }

    public void addComment(ImageIcon profilePicture, String user, Date commentDate, String commentContent){
        this.CommentsPanel.add(new Comment(profilePicture, user, commentDate, commentContent));
        this.CommentsPanel.add(new JToolBar.Separator(new Dimension(2, 2)));
    }
    
    public void addComment(){
        this.CommentsPanel.add(new Comment());
        this.CommentsPanel.add(new JToolBar.Separator(new Dimension(2, 2)));
    }
    
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getUserThatPosted() {
        return userThatPosted;
    }

    public void setUserThatPosted(String userThatPosted) {
        this.userThatPosted = userThatPosted;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public ImageIcon getPostImage() {
        return postImage;
    }

    public void setPostImage(ImageIcon postImage) {
        this.postImage = postImage;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }
    
    private void loadComments(){
        this.CommentsPanel.removeAll();
        // AQUÍ VAN A HACER EL QUERY Y LOS PROCESOS RESPECTIVOS PARA AGREGAR COMENTARIOS.
      Result r=  BinaryDiary.database.QueryExecutor("Match(p:publicacion)-[:HAS_COMMENT]->(C:Comentario) where p.Id_Publicacion='"+this.postID.replace("\"","")+"'  return C.Fecha,C.Usuario,C.Contenido order by C.Fecha desc ");
        System.out.println("Este es el post id: "+postID);
        
       org.neo4j.driver.Record re1;
       
      while (r.hasNext()) {
          org.neo4j.driver.Record r1= r.next();
          Result re=BinaryDiary.database.QueryExecutor("Match(u:usuario)where u.Email='"+r1.get("C.Usuario").toString().replace("\"","")+"' return u.Foto_Perfil,u.Email");
          String contenido=r1.get("C.Contenido").toString().replace("\"", "");
         if(re.hasNext()){
              long epochMilli = r1.get("C.Fecha").asZonedDateTime().toInstant().toEpochMilli();
            Date date = new Date(epochMilli);
          re1 = re.next();
           addComment(new ImageIcon(re1.get("u.Foto_Perfil").toString().replace("\"","")),re1.get("u.Email").toString().replace("\"",""),date,contenido);
             //System.out.println(""+ProfilePanel.profilePicture.toString()+" "+BinaryDiary.userEmail+" "+date.toString()+" "+PostReplyArea.getText());
         }
        
            
          
        
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewComments = new javax.swing.JDialog();
        ScrollPane = new javax.swing.JScrollPane();
        CommentsPanel = new javax.swing.JPanel();
        NameLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        PostImage = new javax.swing.JLabel();
        PostContent = new javax.swing.JLabel();
        ProfilePicture = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PostReplyArea = new javax.swing.JTextArea();
        SendReplyButton = new javax.swing.JButton();
        ViewCommentsButton = new javax.swing.JButton();

        ViewComments.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ViewComments.setTitle("Comentarios");
        ViewComments.setMinimumSize(new java.awt.Dimension(1148, 740));
        ViewComments.setResizable(false);
        ViewComments.setSize(new java.awt.Dimension(1148, 740));
        ViewComments.getContentPane().setLayout(null);

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        CommentsPanel.setBackground(new java.awt.Color(51, 51, 51));
        CommentsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        CommentsPanel.setMaximumSize(new java.awt.Dimension(99999, 99999));
        CommentsPanel.setPreferredSize(new java.awt.Dimension(1148, 707));
        CommentsPanel.setLayout(new javax.swing.BoxLayout(CommentsPanel, javax.swing.BoxLayout.Y_AXIS));
        ScrollPane.setViewportView(CommentsPanel);

        ViewComments.getContentPane().add(ScrollPane);
        ScrollPane.setBounds(0, 0, 1164, 710);

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(800, 656));

        NameLabel.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NameLabel.setText("NAME NAME NAME NAME NAME NAME NAME NAME NAME");

        DateLabel.setFont(new java.awt.Font("Leelawadee", 1, 20)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(153, 153, 153));
        DateLabel.setText("DATE DATE DATE");

        PostImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DEFAULT_POST_IMAGE.png"))); // NOI18N
        PostImage.setAlignmentX(0.5F);

        PostContent.setFont(new java.awt.Font("Leelawadee", 0, 18)); // NOI18N
        PostContent.setForeground(new java.awt.Color(255, 255, 255));
        PostContent.setText("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </html>");
        PostContent.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        ProfilePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DEFAULT_PROFILE_PICTURE_SMALL.png"))); // NOI18N

        PostReplyArea.setBackground(new java.awt.Color(80, 80, 80));
        PostReplyArea.setColumns(20);
        PostReplyArea.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        PostReplyArea.setForeground(new java.awt.Color(255, 255, 255));
        PostReplyArea.setLineWrap(true);
        PostReplyArea.setRows(5);
        jScrollPane2.setViewportView(PostReplyArea);

        SendReplyButton.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        SendReplyButton.setForeground(new java.awt.Color(255, 255, 255));
        SendReplyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SEND_BUTTON_ICON.png"))); // NOI18N
        SendReplyButton.setBorder(null);
        SendReplyButton.setBorderPainted(false);
        SendReplyButton.setContentAreaFilled(false);
        SendReplyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SendReplyButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        SendReplyButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        SendReplyButton.setIconTextGap(15);
        SendReplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendReplyButtonActionPerformed(evt);
            }
        });

        ViewCommentsButton.setBackground(new java.awt.Color(73, 73, 73));
        ViewCommentsButton.setFont(new java.awt.Font("Leelawadee", 1, 18)); // NOI18N
        ViewCommentsButton.setForeground(new java.awt.Color(255, 255, 255));
        ViewCommentsButton.setText("Ver Comentarios");
        ViewCommentsButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ViewCommentsButton.setContentAreaFilled(false);
        ViewCommentsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewCommentsButton.setHideActionText(true);
        ViewCommentsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ViewCommentsButton.setIconTextGap(15);
        ViewCommentsButton.setOpaque(true);
        ViewCommentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCommentsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PostContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PostImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ViewCommentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SendReplyButton)))
                                .addGap(12, 12, 12))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(290, 290, 290))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DateLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, Short.MAX_VALUE)
                        .addComponent(PostContent, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PostImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewCommentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SendReplyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SendReplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendReplyButtonActionPerformed
         Result r1= BinaryDiary.database.QueryExecutor("match(P:publicacion)where P.Id_Publicacion='"+this.postID.replace("\"","")+"' create(c:Comentario{Contenido:'"+PostReplyArea.getText()+"',Usuario:'"+BinaryDiary.userEmail+"',Fecha:datetime()}) create (P)-[:HAS_COMMENT]->(c) return c.Fecha,c.Usuario,c.Contenido ");
      
        BinaryDiary.refreshPosts();
    }//GEN-LAST:event_SendReplyButtonActionPerformed

    private void ViewCommentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCommentsButtonActionPerformed
        loadComments();
        ScrollPane.setViewportView(this.CommentsPanel);
        this.ViewComments.setLocationRelativeTo(null);
        this.ViewComments.setVisible(true);
    }//GEN-LAST:event_ViewCommentsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CommentsPanel;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel PostContent;
    private javax.swing.JLabel PostImage;
    private javax.swing.JTextArea PostReplyArea;
    private javax.swing.JLabel ProfilePicture;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton SendReplyButton;
    private javax.swing.JDialog ViewComments;
    private javax.swing.JButton ViewCommentsButton;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
