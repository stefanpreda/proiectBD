import React, { Component } from 'react';
import { Legend, ResponsiveContainer, BarChart, Bar, Tooltip, CartesianGrid,XAxis, YAxis} from 'recharts';
import {Container, Row, Col} from 'react-grid-system';
import axios from 'axios'
import './App.css';

const barChartData= [{
  column1:1,
  column2: 2,
  column3: 3,
}]

class App extends Component {

  constructor(props) {
    console.log("constructor")
    super(props)

    this.state = {
      graph1: [],
      keysGraph1: [],
      graph2: [],
      keysGraph2: [],
      graph3: [],
      keysGraph3: [],
      barChartData : [{
          column1:1,
          column2: 2,
          column3: 3,
      }]
    }
  }

  getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

  componentWillMount() {
     console.log("in mount")
     axios.get('http://localhost:8080/statsbedrooms').then(response =>  this.setState({graph1: [response.data], keysGraph1 : Object.keys(response.data)}))
     axios.get('http://localhost:8080/statsrooms').then(response => this.setState({graph2 : [response.data], keysGraph2: Object.keys(response.data)}))
     axios.get('http://localhost:8080/neighborhood').then(response => this.setState({graph3: [response.data], keysGraph3 : Object.keys(response.data)}))
  }

  shouldComponentUpdate() {
    console.log("should") 
    return true
  }

  componentDidUpdate() {
    console.log("did update")
  }
  render() {
    console.log("state: " + JSON.stringify(this.state))
    return (
          <div>
              <Row>
                <Col lg={6}>
                  <ResponsiveContainer width='100%' aspect={6.0/4.0}>
						        <BarChart data={this.state.graph1} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                      <XAxis dataKey="name"/>
                      <YAxis/>
                      <CartesianGrid strokeDasharray="3 3"/>
                      <Tooltip/>
                      <Legend />
                      {this.state.keysGraph1.map((key) => <Bar dataKey={key} fill={this.getRandomColor()} />)} 	   					
						        </BarChart>
                  </ResponsiveContainer>
                  </Col>
                  </Row>
                  <Row>
                    <Col lg={12}>
                    <ResponsiveContainer width='100%' aspect={6.0/4.0}>
						        <BarChart data={this.state.graph3} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                      <XAxis dataKey="name"/>
                      <YAxis/>
                      <CartesianGrid strokeDasharray="3 3"/>
                      <Tooltip/>
                      <Legend />
                       {this.state.keysGraph3.map((key) => <Bar dataKey={key} fill={this.getRandomColor()} />)} 	   
						        </BarChart>
                  </ResponsiveContainer>
                  </Col>
                </Row>
          </div>

    );
  }
}

export default App;
