window.addEventListener('load', function(e) {
	  console.log('document loaded');
	  init();
	  init2(); 
	});



function init() {
	
//	var getId = document.getElementById('test');
//
//	while(getId.firstChild){
//	    getId.removeChild(getId.firstChild);
//	}
	
	let xhr = new XMLHttpRequest(); 
	xhr.open('GET', 'api/posts/'); 
	
    xhr.onreadystatechange = function() {
    	if (xhr.readyState === 4) {
    		if (xhr.status === 200) {
    			let response = xhr.responseText;
    			console.log(response);
    			let posts = JSON.parse(response);
    			displayPosts(posts); 
    		} else {
    			console.log("Status: " + xhr.status + xhr.statusTest);
    		}
    	}
    	
    } 
    xhr.send();
    
}; 

function init2(){
	document.inputForm.makingButtonsGreatAgain.addEventListener('click',function(event){
		event.preventDefault(); 
		addPost(event); 
	})
}; 

function displayPosts(posts){
	
	var getId = document.getElementById('test');
		
	var tbl = document.createElement('TABLE');
	var header = tbl.createTHead();
	var row = header.insertRow(0);
	var cell = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	cell.innerHTML = "<strong>ID</strong>";
	cell2.innerHTML = "<strong>TITLE</strong>";
	cell3.innerHTML = "<strong>DESCRIPTION</strong>";
	cell4.innerHTML = "<strong>HYPERLINK</strong>";
	cell5.innerHTML = "<strong>USERNAME</strong>";


	  posts.forEach(function(value, index, array) {
	    var tr = tbl.insertRow(index);
	    tbl.appendChild(tr);
	    
	    var td = document.createElement('td');
	    td.textContent = posts[index].id;
	    tr.appendChild(td);
	    
	    var td = document.createElement('td');
	    td.textContent = posts[index].title;
	    td.setAttribute("id", "description");
	    tr.appendChild(td);
	    
	    var td = document.createElement('td');
	    td.textContent = posts[index].description;
	    tr.appendChild(td);
	    
	    var td = document.createElement('td');
	    td.textContent = posts[index].hyperlink;
	    tr.appendChild(td);
	    
	    var td = document.createElement('td');
	    td.textContent = posts[index].username;
	    tr.appendChild(td);
	    
	});
		
	document.body.appendChild(tbl);
    document.getElementById("description").addEventListener("click", hello);

	
}; 

function hello(){
	console.log("hello");
};

function addPost(event){
	var xhr2 = new XMLHttpRequest();
	xhr2.open('POST', 'api/posts', true);
	
	xhr2.setRequestHeader("Content-type", "application/json"); 

	xhr2.onreadystatechange = function() {
		  if (xhr2.readyState === 4 ) {
		    if ( xhr2.status == 200 || xhr2.status == 201 ) { 
		      var data = JSON.parse(xhr2.responseText);
		      console.log(data);
		      init();
//		      displayPosts();
		    }
		    else {
		      console.log("POST request failed.");
		      console.error(xhr2.status + ': ' + xhr2.responseText);
		    }
		  }
		};
		
	var form = event.target.parentElement; 
	
	var postObject = {
		title: form.title.value, 
		description: form.description.value,
		hyperlink: form.hyperlink.value,
		username: form.username.value
	};
		
	var postObjectJson = JSON.stringify(postObject);
	console.log(postObjectJson); 
	xhr2.send(postObjectJson);
};