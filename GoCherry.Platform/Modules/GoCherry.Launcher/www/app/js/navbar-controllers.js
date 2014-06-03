"use strict";

/* Controllers */

function Controller() {
  this.hndlr = "navBarCntrlr";
}

function Gate() {
  this.agent = "/gate";
  this.open = this.agent + "/open";
  this.close = this.agent + "/close";
}

var navBarCntrlrs = angular.module("navBarCntrlrs", []);
var gate = new Gate(), cntrlr = new Controller();

navBarCntrlrs.controller(cntrlr.hndlr, function($scope, $http) {
  function clear() {
	$scope.signInFrm.email = null;
	$scope.signInFrm.password = null;
  };

  function toggle() {
	var tmp =  $scope.signIn;
	 $scope.signIn = $scope.signOut;
	 $scope.signOut = tmp;
  }

  function next() {
	clear();
	toggle();
  }

  $scope.signInFrm = {};

  $scope.signInFrm.signMeIn = function(item, event) {
	var responsePromise = $http.post(gate.open, new User($scope.signInFrm.user, $scope.signInFrm.password), {});

	responsePromise.success(function(response, status, headers, config) {
	  cout("Server saved data [" + response.id + "], [" + response.status.code + "]");
	  next();
	});

	responsePromise.error(function(data, status, headers, config) {
	  alert("Submitting form failed!");
	});
  }

  $scope.signOutWdgt = {};

  $scope.signOutWdgt.signMeOut = function(item, event) {
    var responsePromise = $http.post(gate.close, null, {});

	responsePromise.success(function(response, status, headers, config) {
	  cout("Server saved data [" + response.id + "], [" + response.status.code + "]");
	  next();
	});

	responsePromise.error(function(data, status, headers, config) {
	  alert("Submitting form failed!");
	});
  }
});
