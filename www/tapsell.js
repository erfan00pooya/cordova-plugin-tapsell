module.exports = {

    init:: function(Key) {
		cordova.exec(
			function (result) {
			}, 
			function (error) {
			},
			'TapsellVideo',
			'init',			
			[Key]
		); 
	},
	
    showVideo: function () {
		cordova.exec(null, null, "TapsellVideo", "showVideo", []);
    }
};