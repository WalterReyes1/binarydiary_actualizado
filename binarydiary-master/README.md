# BinaryDiary

## Parte 1

Cada cuenta tiene los siguientes atributos
1. Email (valido) Único
2. Nombres
3. Apellidos
4. Contraseña (encriptada usando SHA)
5. Fecha de nacimiento
6. Perfil
  - Foto de perfil
  - Foto de portada
  - Datos personales (texto)
7. Publicaciones
  - Contenido (texto o imagen)
  - Fecha de publicación
  - Comentarios
    - Email del usuario que comenta
    - Contenido (texto)
    
En el registro de la cuenta de usuario solamente se piden los primeros 5 atributos.

## Parte #2
En la ventana principal se debe mostrar:

1. Una opción para poder editar el perfil.
2. Una opción para poder crear publicaciones y ver las publicaciones publicadas
3. Una opción para buscar personas por nombre o apellidos para enviarles solicitudes de amistad
4. Un cuadro para aceptar las solicitudes de amistad
5. Un panel para mostrar las publicaciones de los amigos
  - Para cada publicación se debe mostrar
    - El nombre completo de la persona que publica
    - El tiempo transcurrido desde que se publicó
    - El contenido
    - Una caja de texto para comentar la publicación
