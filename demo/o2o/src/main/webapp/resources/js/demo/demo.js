$(function(){

	var numberUrl = '/o2o/admin/numberconvert?number=';
	var empty = 'invalid';
	$('#submit').click(function(){
			var number = $('#number').val();
			if (!number) {
				$('#English').val(empty);
				$.toast('Please input a number');
				return;
			}
			
			var tempUrl = '';
			tempUrl += numberUrl;
			tempUrl += number;
			$.ajax({
				url:  tempUrl,
				type: 'POST',
				contentType : false,
				processData : false,
				cache : false,
				success:function(data){
					if (data.success) {
						$('#English').val(data.English);
						$.toast('well done');
					}
					else {
						
						$('#English').val(data.errMsg);
						$.toast('failed ' + data.errMsg);
					}
				}
			});
		});
})