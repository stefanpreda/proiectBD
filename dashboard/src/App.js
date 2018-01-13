import React, { Component } from 'react';
import { Legend, ResponsiveContainer, BarChart, Bar } from 'recharts';
import {Container, Row, Col} from 'react-grid-system';
import './App.css';

const barChartData= [{
  column1:1,
  column2: 2,
  column3: 3,
}]

class App extends Component {
  render() {
    return (
          <div>
              <Row>
                <Col lg={6}>
                  <ResponsiveContainer width='100%' aspect={6.0/4.0}>
						        <BarChart data={barChartData} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                            <Bar dataKey='column1' fill='#83a754'/>
                            <Bar dataKey='column2' fill='#cecece'/>
                            <Bar dataKey='column3' fill='#da5d2c'/>		    
						          <Legend/>						
						        </BarChart>
                  </ResponsiveContainer>
                  </Col>
                  <Col lg={6}>
                  <ResponsiveContainer width='100%' aspect={6.0/4.0}>
						        <BarChart data={barChartData} margin={{top: 50, right: 30, left: 0, bottom: 0}}>
                            <Bar dataKey='column1' fill='#83a754'/>
                            <Bar dataKey='column2' fill='#cecece'/>
                            <Bar dataKey='column3' fill='#da5d2c'/>		    
						          <Legend/>						
						        </BarChart>
                  </ResponsiveContainer>
                  </Col>
                  </Row>
          </div>

    );
  }
}

export default App;
