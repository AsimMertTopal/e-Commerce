package kodlamaio.northwind.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.Entities.concretes.Product;
import kodlamaio.northwind.Entities.dtos.ProductWithCategoryDto;
import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;


@RestController
@RequestMapping("api/products")
@CrossOrigin
public class ProductsController {
	private ProductService productService;
	
	private ProductsController(ProductService productService) {
		super();
		this.productService=productService;
	}



	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
    	 return this.productService.getAll();
		

}
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
		
	}
	@GetMapping("/getByProductName")
	public DataResult<List<Product>>getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
		
	}
	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<List<Product>> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam ("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
	}
	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
		 
	 }
	@GetMapping("getAllByPage")
	DataResult<List<Product>> getAll(int pageNo,int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	@GetMapping("getAllAsc")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
		
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
   	 return this.productService.getProductWithCategoryDetails();
	 
	}
}