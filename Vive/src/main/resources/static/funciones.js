function eliminar(dni) {
	swal({
		title: "¿Estás seguro?",
		text: "Una vez eliminado, no podrá recuperar este archivo!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminarP/" + dni,
					success: function(res) {
						console.log(res);
					}
				});
				swal("Poof! Your imaginary file has been deleted!", {
					icon: "success",
				}).then((OK) => {
					location.href = "/listar";
				});
			} else {
				swal("¡Tu archivo imaginario está a salvo!");
			}
		});
}

function eliminarD(id) {
	swal({
		title: "¿Estás seguro?",
		text: "Una vez eliminado, no podrá recuperar este archivo!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminarD/" + id,
					success: function(res) {
						console.log(res);
					}
				});
				swal("Poof! Your file has been deleted!", {
					icon: "success",
				}).then((OK) => {
					location.href = "/listar";
				});
			} else {
				swal("¡Tu archivo imaginario está a salvo!");
			}
		});
} 