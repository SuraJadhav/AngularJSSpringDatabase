<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

 <script
     src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
     
     <script>
     var app=angular.module('myapp',[]);
     app.controller('mycontroller',function($scope,$http){
    	 $scope.users=[]
    	 $scope.userform = {
    			  name : "",
    			  mail : ""
    			   };
    	 
    	 
    	 $http({
             url: "empDetails",
             contentType : 'application/json; charset=utf-8',
   	    	 dataType : 'json', 
             method: "GET",    
             
         })
         .then(function(response) {
                 // if success       	
         	 console.log("succcess"); 
                 //var resp=response.data;
                 
                console.log(response.data);
                $scope.users = response.data;
         }, 
         function(data) { // optional
                 // failed		                 
         	 console.log(" failed"); 	         	
         });
    	 
    	 

     
       //getUserDetails();

     function getUserDetails() {
     $http({
    	 
    	 
       method : 'GET',
       url : 'empDetails'
      }).then(function successCallback(response) {
    	  
    	  console.log(response)
      $scope.users = response.data;
      }, function errorCallback(response) {
       console.log(response.statusText);
      });
     } 
 
     
     $scope.processuser= function(){
    	 
    	 $http({
    		    method : 'POST',
    		    url : 'addUser',
    		    data : angular.toJson($scope.userform),
    		    headers : {
    		    'Content-Type' : 'application/json'
    		}
    		
    		
    	 }).then(getUserDetails(),clearform()).success(function(data){
    		 $scope.users=data;
    	 }); 
 }
    	 
    	  function clearForm() {
    		    $scope.userform.name = "";
    		    $scope.userform.mail = "";
    		    document.getElementById("name").disabled = false;
    		  };
    		 
     });
     
     </script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myapp" ng-controller="mycontroller">
<form ng-submit="processuserDetail()">
Name:<input type="text" id="name" ng-model="userform.name"></br>
Email:<input type="text" id="mail" ng-model="userform.mail"><br>
<input type="submit" value="click to add" ng-click="processuser()">

</form>
<table>
 <tr ng-repeat="user in users">
        <td>{{ user.name}}</td>
        <td>{{ user.mail }}</td>
        <td><a ng-click="editUser(user)" class="btn btn-primary btn-sm">Edit</a>
           | <a ng-click="deleteUser(user)" class="btn btn-danger btn-sm">Delete</a></td>
      </tr>
      </table>
</body>
</html>