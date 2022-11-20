package Classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import org.neo4j.driver.Result;

/**
 *
 * @author Pedro
 */
public class BinaryDiary extends javax.swing.JFrame {

    static Neo4JConnect database;
    static String userEmail;
    static String name;

    // RECUERDEN QUE SI OCUPAN ALGUN EMAIL U OTRA COSA
    // UTILIZEN METODOS ESTÁTICOS
    // PUEDEN REALIZAR MÉTODOS DESDE OTRAS CLASES CON LA INSTANCIA ESTÁTICA
    // BinaryDiary.database.executeQuery();
    /**
     * Creates new form BinaryDiary
     */
    public BinaryDiary() {
        initComponents();

        ImageIcon favicon = new javax.swing.ImageIcon(".\\ASSETS\\SMALL_LOGO.png");
        setIconImage(favicon.getImage());
        database = new Neo4JConnect();
        database.connect();

        loginScreen();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        ProfileButton = new javax.swing.JButton();
        FriendsButton = new javax.swing.JButton();
        PostsButton = new javax.swing.JButton();
        ContentPanel = new javax.swing.JScrollPane();
        TopPanel = new javax.swing.JPanel();
        LogoLabel = new javax.swing.JLabel();
        SearchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BinaryDiary");
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        SidePanel.setBackground(new java.awt.Color(51, 51, 51));

        ProfileButton.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        ProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        ProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DEFAULT_PROFILE_PICTURE_SMALL.png"))); // NOI18N
        ProfileButton.setText("Perfil");
        ProfileButton.setBorder(null);
        ProfileButton.setBorderPainted(false);
        ProfileButton.setContentAreaFilled(false);
        ProfileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProfileButton.setEnabled(false);
        ProfileButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        ProfileButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ProfileButton.setIconTextGap(15);
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        FriendsButton.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        FriendsButton.setForeground(new java.awt.Color(255, 255, 255));
        FriendsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FRIENDS_ICON_SMALL.png"))); // NOI18N
        FriendsButton.setText("Amigos");
        FriendsButton.setBorder(null);
        FriendsButton.setBorderPainted(false);
        FriendsButton.setContentAreaFilled(false);
        FriendsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FriendsButton.setEnabled(false);
        FriendsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        FriendsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        FriendsButton.setIconTextGap(15);
        FriendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FriendsButtonActionPerformed(evt);
            }
        });

        PostsButton.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        PostsButton.setForeground(new java.awt.Color(255, 255, 255));
        PostsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/POSTS_ICON_SMALL.png"))); // NOI18N
        PostsButton.setText("Publicaciones");
        PostsButton.setBorder(null);
        PostsButton.setBorderPainted(false);
        PostsButton.setContentAreaFilled(false);
        PostsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PostsButton.setEnabled(false);
        PostsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        PostsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PostsButton.setIconTextGap(15);
        PostsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addComponent(PostsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(FriendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ProfileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FriendsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PostsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TopPanel.setBackground(new java.awt.Color(102, 102, 102));

        LogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/SMALL_LOGO.png"))); // NOI18N

        SearchTextField.setBackground(new java.awt.Color(82, 82, 82));
        SearchTextField.setFont(new java.awt.Font("Leelawadee UI", 1, 16)); // NOI18N
        SearchTextField.setForeground(new java.awt.Color(255, 255, 255));
        SearchTextField.setText("Buscar personas . . . ");
        SearchTextField.setBorder(null);
        SearchTextField.setCaretColor(new java.awt.Color(255, 255, 255));
        SearchTextField.setEnabled(false);
        SearchTextField.setMargin(new java.awt.Insets(2, 0, 2, 0));
        SearchTextField.setSelectionColor(new java.awt.Color(102, 255, 102));
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchTextField))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PostsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PostsButtonActionPerformed
        refreshPosts();
    }//GEN-LAST:event_PostsButtonActionPerformed

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileButtonActionPerformed
        refreshProfile();
    }//GEN-LAST:event_ProfileButtonActionPerformed

    private void FriendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FriendsButtonActionPerformed
        refreshFriendRequests();
    }//GEN-LAST:event_FriendsButtonActionPerformed

    private void SearchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String param = SearchTextField.getText();
            searchResults(param);
        }
    }//GEN-LAST:event_SearchTextFieldKeyPressed

    private static ImageIcon processImage(ImageIcon image, int width, int height) {
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_FAST));
    }

    private void loginScreen() {
        LoginPanel login = new LoginPanel();
        login.setSize(1142, 748);
        login.setLocation(0, 0);

        ContentPanel.removeAll();
        ContentPanel.add(login);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    public void searchResults(String search) {

        FriendsPanel searchPeople = new FriendsPanel();

        /*
                SE SUPONE QUE EN VEZ DE ESTE FOR-LOOP
                SE REALIZA EL QUERY, con un WHILE-LOOP
         */
        Result r = BinaryDiary.database.QueryExecutor("match(u:usuario) where not u.Email='" + BinaryDiary.userEmail + "' and ((toLower(u.Nombre) contains toLower('" + SearchTextField.getText() + "')  or toLower(u.Apellido) contains toLower('" + SearchTextField.getText() + "')))  return u.Nombre, u.Apellido, u.Foto_Perfil,u.Email");

        while (r.hasNext()) {

            org.neo4j.driver.Record r1 = r.next();

            Result AC = BinaryDiary.database.QueryExecutor("match (u2:usuario)-[:IS_FRIEND_OF]->(u:usuario)<-[:IS_FRIEND_OF]-(u3:usuario)"
                    + "where u3.Email = '" + BinaryDiary.userEmail + "' and u2.Email='" + r1.get("u.Email").asString().replace("\"", "") + "'"
                    + "return count (u) as friends_in_common");
            int fc = AC.single().get(0).asInt();

            Result validation = BinaryDiary.database.QueryExecutor("match (u:usuario),(u2:usuario)" +
"where u.Email = '"+BinaryDiary.userEmail+"' and u2.Email = '"+r1.get("u.Email").toString().replace("\"","")+
"' return exists((u)-[:WANTS_TO_FRIEND]->(u2)) or exists((u2)-[:WANTS_TO_FRIEND]->(u))");

           /* boolean flag1 = false;
            while (validation.hasNext()) {
                org.neo4j.driver.Record r2 = validation.next();
                flag1 = r2.get(0).asBoolean();
            }*/
           boolean check = validation.single().get(0).asBoolean();
            searchPeople.addResult(new ImageIcon(r1.get("u.Foto_Perfil").toString().replace("\"", "")), r1.get("u.Nombre").toString().replace("\"", "") + " " + r1.get("u.Apellido").toString().replace("\"", ""), fc, check, r1.get("u.Email").toString().replace("\"", ""));
        }

        /*  for (int i = 0; i < 12; i++) {
            if(i % 2 == 0)
                searchPeople.addResult(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Pedro Mendoza", 69, true);
            else{
                searchPeople.addResult(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Walter Reyes", 10, false);
            }
        }
         */
        JScrollPane scrollPane = new JScrollPane(searchPeople, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setBackground(new Color(102, 102, 102));
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(66, 135, 23);
            }
        });

        //friends.setSize(1128, 707);
        //friends.setLocation(0, 0);
        scrollPane.setSize(1142, 748);
        scrollPane.setLocation(0, 0);
        scrollPane.setViewportView(searchPeople);
        ContentPanel.removeAll();
        //ContentPanel.add(post);
        ContentPanel.add(scrollPane);
        ContentPanel.revalidate();
        ContentPanel.repaint();

    }

    static void refreshResults() {
        FriendsPanel searchPeople = new FriendsPanel();
        /*
                SE SUPONE QUE EN VEZ DE ESTE FOR-LOOP
                SE REALIZA EL QUERY, con un WHILE-LOOP
         */
 /*
        for (int i = 0; i < 12; i++) {
            if(i % 2 == 0)
                searchPeople.addResult(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Pedro Mendoza", 69, true);
            else{
                searchPeople.addResult(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Walter Reyes", 10, false);
            }
        }*/

        JScrollPane scrollPane = new JScrollPane(searchPeople, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setBackground(new Color(102, 102, 102));
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(66, 135, 23);
            }
        });

        //friends.setSize(1128, 707);
        //friends.setLocation(0, 0);
        scrollPane.setSize(1142, 748);
        scrollPane.setLocation(0, 0);
        scrollPane.setViewportView(searchPeople);
        ContentPanel.removeAll();
        //ContentPanel.add(post);
        ContentPanel.add(scrollPane);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    static void refreshPosts() {
        // HAGAN SU CODIGO AQUI

        //  COSAS DE PRUEBA
        //  IGNORAR
        PostsPanel post = new PostsPanel(BinaryDiary.name);

        /*
                SE SUPONE QUE EN VEZ DE ESTE FOR-LOOP
        
                SE REALIZA EL QUERY, con un WHILE-LOOP
                
         */
        Result r1 = BinaryDiary.database.QueryExecutor("Match(u:usuario)-[:IS_FRIEND_OF]->(u2:usuario)-[m:MAKES_POST]->(p:publicacion)"
                + "  where u.Email='" + BinaryDiary.userEmail + "'  return distinct  p.Id_Publicacion as Id_Publicacion,"
                + " p.Fecha as Fecha,p.Contenido as Contenido,p.Foto_Publicacion as Foto_Publicacion, u2.Foto_Perfil as Foto_Perfil , u2.Nombre as Nombre, u2.Apellido as Apellido"
                + "    union match(u)-[:MAKES_POST]->(p1:publicacion) where u.Email ='" + BinaryDiary.userEmail + "'return distinct p1.Id_Publicacion as Id_Publicacion, "
                + "p1.Fecha as Fecha, p1.Contenido as Contenido, p1.Foto_Publicacion as Foto_Publicacion ,u.Foto_Perfil as Foto_Perfil ,u.Nombre as Nombre, u.Apellido as Apellido order by Fecha desc");

        while (r1.hasNext()) {

            org.neo4j.driver.Record r = r1.next();
            //  Date d1 = sdformat.parse(r.next().get("Fecha").toString().replace("\"",""));
            // Instant instant = r.get("Fecha").asZoneDateTime().toInstant(ZoneOffset.UTC);
            long epochMilli = r.get("Fecha").asZonedDateTime().toInstant().toEpochMilli();
            Date date = new Date(epochMilli);
            String path = r.get("Foto_Publicacion").asString();
            ImageIcon img = new ImageIcon(path);
            if (path == "null") {
                img = null;
            }
            post.addPost(new ImageIcon(r.get("Foto_Perfil").asString()), date, r.get("Nombre").asString() + " " + r.get("Apellido").asString(), r.get("Contenido").asString(), img,r.get("Id_Publicacion").toString());
        }

        JScrollPane scrollPane = new JScrollPane(post, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setBackground(new Color(102, 102, 102));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(66, 135, 23);
            }
        });

        //post.setSize(1128, 707);
        //post.setLocation(0, 0);
        scrollPane.setSize(1142, 748);
        scrollPane.setLocation(0, 0);
        scrollPane.setViewportView(post);

        ContentPanel.removeAll();
        //ContentPanel.add(post);
        ContentPanel.add(scrollPane);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    static void refreshFriendRequests() {
        // HAGAN SU CODIGO ACA
        FriendsPanel friends = new FriendsPanel();
        /*
                SE SUPONE QUE EN VEZ DE ESTE FOR-LOOP
                SE REALIZA EL QUERY, con un WHILE-LOOP
         
        for (int i = 0; i < 12; i++) {
            if (i % 2 == 0) {
                friends.addFriendRequest(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Pedro Mendoza", 69);
            } else {
                friends.addFriendRequest(new ImageIcon("C:\\Users\\Pedro\\Pictures\\luis.jpg"), "Walter Reyes", 10);
            }
        }*/

        Result r = BinaryDiary.database.QueryExecutor("match (u:usuario)-[:WANTS_TO_FRIEND]->(u2:usuario)"
                + "where u2.Email = '" + BinaryDiary.userEmail + "'  "
                + "return u.Nombre, u.Apellido, u.Foto_Perfil,u.Email");

        while (r.hasNext()) {
            org.neo4j.driver.Record r1 = r.next();
            Result AC = BinaryDiary.database.QueryExecutor("match (u2:usuario)-[:IS_FRIEND_OF]->(u:usuario)<-[:IS_FRIEND_OF]-(u3:usuario)"
                    + "where u3.Email = '" + BinaryDiary.userEmail + "' and u2.Email='" + r1.get("u.Email").asString().replace("\"", "") + "'"
                    + "return count (u) as friends_in_common");
            int fc = AC.single().get(0).asInt();
            friends.addFriendRequest(new ImageIcon(r1.get("u.Foto_Perfil").toString().replace("\"", "")), r1.get("u.Nombre").toString().replace("\"", "") + " " + r1.get("u.Apellido").toString().replace("\"", ""), fc);

            //addResult(new ImageIcon(r1.get("u.Foto_Perfil").toString().replace("\"", "")), r1.get("u.Nombre").toString().replace("\"", "") + " " + r1.get("u.Apellido").toString().replace("\"", ""), fc, false, r1.get("u.Email").toString().replace("\"", ""));
        }

        JScrollPane scrollPane = new JScrollPane(friends, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getHorizontalScrollBar().setBackground(new Color(102, 102, 102));
        scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(66, 135, 23);
            }
        });

        //friends.setSize(1128, 707);
        //friends.setLocation(0, 0);
        scrollPane.setSize(1142, 748);
        scrollPane.setLocation(0, 0);
        scrollPane.setViewportView(friends);
        ContentPanel.removeAll();
        //ContentPanel.add(post);
        ContentPanel.add(scrollPane);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    static void sendFriendRequest(String firstUserEmail, String secondUserEmail) {
        /*
            CREAR RELACIÓN [:WANTS_TO_FRIEND]
         */
        Result r = BinaryDiary.database.QueryExecutor("match (u:usuario), (u2:usuario) where u.Email = '" + firstUserEmail + "' and u2.Email='" + secondUserEmail + "'"
                + " create (u)-[:WANTS_TO_FRIEND]->(u2) return u.Email, u2.Email");
        if (r.hasNext()) {
            System.out.println("solicitud enviada");
        }
    }

    static void login(String firstName, String userEmail, ImageIcon profilePicture) {

        ProfileButton.setIcon(processImage(profilePicture, 60, 60));
        ProfileButton.setText(firstName);
        BinaryDiary.userEmail = userEmail;
        ProfileButton.setEnabled(true);
        FriendsButton.setEnabled(true);
        PostsButton.setEnabled(true);
        SearchTextField.setEnabled(true);
        refreshPosts();
    }

    static void refreshProfile() {

        /*
            AQUI SE DEBE REALIZAR EL QUERY PARA PODER CREAR EL NUEVO PROFILE PANEL
         */
        Result r = BinaryDiary.database.QueryExecutor("match(u:usuario) where u.Email='" + BinaryDiary.userEmail + "' return u.Nombre, u.Apellido,u.Datos_Personales,u.Foto_Portada,u.Foto_Perfil");
        org.neo4j.driver.Record r1 = r.next();

        Result amigos = BinaryDiary.database.QueryExecutor("match (u:usuario)-[:IS_FRIEND_OF]->(u2:usuario)\n"
                + "where u.Email = '" + BinaryDiary.userEmail + "'"
                + "return count (u2) as amigos");

        org.neo4j.driver.Record rAmigos = amigos.next();
        Result Publicaciones = BinaryDiary.database.QueryExecutor("match (u:usuario)-[:MAKES_POST]->(p:publicacion)"
                + "where u.Email = '" + BinaryDiary.userEmail + "'"
                + "return count (p) as publicaciones");
        org.neo4j.driver.Record P_Publicaciones = Publicaciones.next();

        ProfilePanel profile = new ProfilePanel(r1.get("u.Nombre").toString().replace("\"", ""), r1.get("u.Apellido").toString().replace("\"", ""), r1.get("u.Datos_Personales").toString().replace("\"", ""),
                new ImageIcon(r1.get("u.Foto_Portada").toString().replace("\"", "")), new ImageIcon(r1.get("u.Foto_Perfil").toString().replace("\"", "")),
                rAmigos.get("amigos").asInt(), P_Publicaciones.get("publicaciones").asInt());
        profile.setSize(1142, 748);
        profile.setLocation(0, 0);

        ContentPanel.removeAll();
        ContentPanel.add(profile);
        ContentPanel.revalidate();
        ContentPanel.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BinaryDiary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BinaryDiary().setVisible(true);
        });

    }

    static void UpdatePicture(ImageIcon img) {
        ProfileButton.setIcon(processImage(img, 60, 60));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JScrollPane ContentPanel;
    private static javax.swing.JButton FriendsButton;
    private javax.swing.JLabel LogoLabel;
    private static javax.swing.JButton PostsButton;
    private static javax.swing.JButton ProfileButton;
    private static javax.swing.JTextField SearchTextField;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JPanel TopPanel;
    // End of variables declaration//GEN-END:variables
}
