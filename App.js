import logo from './logo.svg';
import './App.css';
import Navbar from './Component/Navbar';
import { Routes } from 'react-router-dom';
import AddProduct from './Component/AddProduct';
import Home from './Component/Home';
import EditProduct from './Component/EditProduct';
import {Route} from 'react-router-dom';



function App() {
  return (
     <>
     <Navbar/>
     <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='/addProduct' element={<AddProduct/>}></Route>
      <Route path='/editProduct/:id' element={< EditProduct/>}></Route>
     </Routes>
     </>
  );
}

export default App;
