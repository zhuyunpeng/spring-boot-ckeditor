<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>test</title>

    <script src="/jquery-2.1.1.js"></script>
    <script src="/ckeditor/ckeditor.js"></script>
</head>
<body>

<form>
            <textarea name="editor1" id="editor1" rows="20" cols="40">
                This is my textarea to be replaced with CKEditor.
            </textarea>
    <script>
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace( 'editor1' );
    </script>
</form>
</body>
<script>


</script>
</html>