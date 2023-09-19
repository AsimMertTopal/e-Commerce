package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.Entities.concretes.Product;
import kodlamaio.northwind.Entities.dtos.ProductWithCategoryDto;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	DataResult<List<Product>> getAllSorted();
	Result add(Product product);
		
	DataResult<List<Product>> getByProductName(String productName);
	  
	DataResult<List<Product>> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	  
     DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	  
     DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
     DataResult<List<Product>> getByProductNameContains(String productName);
	  
     DataResult<List<Product>> getByProductNameStartsWith(String productName);

     DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId); 
     DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
     }
