it_osl_jscomponent_web_screens_Fabric = function () {
    var connector = this;
    var element = connector.getElement();
    element.innerHTML = "<canvas id=\"c\" width=1024 height=768></canvas>";

	var canvas = new fabric.Canvas('c');
	canvas.setBackgroundImage('VAADIN/fabric/sfondo.png',canvas.renderAll.bind(canvas), {
		backgroundImageOpacity: 0.5,
		backgroundImageStretch: false
	});

	canvas.on('mouse:down', function(options) {
		if (!options.target) {
			console.log(options.e.clientX, options.e.clientY);
			var circle = new fabric.Circle({ left:options.e.clientX, top:options.e.clientY,  radius: 20, fill: 'red' });
			canvas.add(circle);
			circle.on('selected', function() {
              console.log('selected a circle');
              connector.selectedCircle('ciao');
            });
            connector.createdObject();
		}
		else{
			console.log('selected a circle');
		}
	});
    connector.onStateChange = function () {
		console.log('passo1');
        var state = connector.getState();
        var data = state.data;
		console.log('passo2');
        var circle = new fabric.Circle({ left:data.left, top:data.top,  radius: 20, fill: 'blue' });
		console.log('passo3');
        canvas.add(circle);
		console.log('passo4');
    }
};