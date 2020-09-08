<html>
<body>

	<h1>Stock Prediction Application</h1>
	<h2>Please upload data as .txt file</h2>
	
	<font color="red">${error}</font>
	<form method="POST"
		action="/api-investment/stock-prediction/uploadData"
		enctype="multipart/form-data">
		<input type="file" name="file" /><br /> <br /> <input type="submit"
			value="Submit" />
	</form>

</body>
</html>