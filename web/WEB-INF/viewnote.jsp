<%-- 
    Document   : viewnote
    Created on : 31-Jan-2023, 7:01:57 AM
    Author     : mdkul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        Title: ${note.title}<br>
        Contents: ${note.content}
        <br>
        <a href="note?edit">Edit
    </body>
</html>
