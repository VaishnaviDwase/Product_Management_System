import  {  useEffect, useState } from 'react'
import React from 'react'
import product_service from '../Service/product_service';
import {  useNavigate, useParams } from 'react-router-dom'


const EditProduct = () => {
  const [product, setProduct] = useState({
    id:'',
    productName: '',
    description: '',
    price: '',
    status: '',
  });

  const navigate=useNavigate();

  const {id}=useParams();
  console.log(id);

  const [msg,setMsg]=useState("");

  useEffect(()=>{
     product_service.getProductById(id)
     .then((res)=>{
      setProduct(res.data); 
     }).catch((error)=>{
      console.log(error);
     })
  },[]);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const productRegister = (e) => {
    e.preventDefault();
    product_service
      .saveProduct(product)
      .then((res) => {
        console.log('Product edit successfully');
        setMsg("Product edit successfully");
        navigate("/");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container mt-3">
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header fs-3 text-center">Edit Product</div>
            {
              msg &&
               <p className='fs-4 text-center text-success '>{msg}</p>
            }
            <div className="card-body">
              <form onSubmit={(e)=>productRegister(e)}>
                <div className="mb-3">
                  <label htmlFor="productName">Enter product name</label>
                  <input
                    type="text"
                    id="productName"
                    name="productName"
                    className="form-control"
                    value={product.productName}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="description">Enter product description</label>
                  <input
                    type="text"
                    id="description"
                    name="description"
                    className="form-control"
                    value={product.description}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="price">Enter product price</label>
                  <input
                    type="text"
                    id="price"
                    name="price"
                    className="form-control"
                    value={product.price}
                    onChange={handleChange}
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="status">Enter product status</label>
                  <input
                    type="text"
                    id="status"
                    name="status"
                    className="form-control"
                    value={product.status}
                    onChange={handleChange}
                  />
                </div>
                <button type="submit" className="btn btn-primary col-md-12">
                  Edit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default EditProduct;