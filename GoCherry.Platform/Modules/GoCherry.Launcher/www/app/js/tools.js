function cout(msg) {
  if (console)
    if (msg)
      console.log(msg);
    else
	  console.log('Logging event received with undefined message!');
  else
	alert("[" + msg + "]")
}
