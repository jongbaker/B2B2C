/**
 * Created by myvisi on 2018/4/27.
 */
    //2.定义一个controller
    //注入controller
app.controller('brandController',function ($scope,$controller,brandService) {

    $controller('baseController',{$scope:$scope})

    //分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page,rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }


    $scope.save = function(){
        var item = $scope.entity.id;

        var methodItem = brandService.add($scope.entity);
        if (item!=null){
            methodItem = brandService.update($scope.entity);
        }

        methodItem.success(
            function(response){
                if (response.success){
                    $scope.reloadList();
                }else {
                    //原来是考虑后面的共有元素
                    alert(response.message);
                }
            }
        )
    }

    $scope.findOne = function(id){
        brandService.findOne(id).success(
            function(response){
                $scope.entity=response;
            }
        );
    }


    $scope.delete = function(){
        brandService.delete($scope.selectIds).success(
            function(response){
                if (response.success){
                    $scope.reloadList();
                }else {
                    //原来是考虑后面的共有元素
                    alert(response.message);
                }
            }
        )
    }


    $scope.searchEntity = {};
    $scope.search = function (page, rows) {
        brandService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems = response.total;
                $scope.list = response.rows;
            }
        )
    }



















})

