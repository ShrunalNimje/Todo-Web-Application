<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overlay Text on Image</title>
    <style>
        .container {
            position: relative;
            width: 50%;
        }
        .image {
            display: block;
            width: 100%;
            height: auto;
        }
        .text {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
            font-size: 24px;
            font-weight: bold;
            text-shadow: 2px 2px 4px #000000;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="your-screenshot.png" alt="Screenshot" class="image">
        <div class="text">Your New Text</div>
    </div>
</body>
</html>
