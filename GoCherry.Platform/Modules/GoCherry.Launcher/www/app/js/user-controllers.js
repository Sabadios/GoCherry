"use strict";

/* Controllers */

var GoCherryUserCntrlrs = angular.module("GoCherryUserCntrlrs", []);

GoCherryUserCntrlrs.controller("userFrmCntlr", function($scope, $http) {
  $scope.userFrm = {};

  $scope.userFrm.submitUserForm = function(item, event) {
     cout("Submitting form with data [" + $scope.userFrm.ID + "], [" + $scope.userFrm.password + "]");

     var responsePromise = $http.post("/user/save", new User($scope.userFrm.ID, $scope.userFrm.password), {});

     responsePromise.success(function(response, status, headers, config) {
       cout("Server saved data [" + response.id + "], [" + response.parole + "]");
     });

     responsePromise.error(function(data, status, headers, config) {
       alert("Submitting form failed!");
     });
   }
  });
